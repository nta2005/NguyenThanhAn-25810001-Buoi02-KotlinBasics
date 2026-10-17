package com.example.bookshelf.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.R
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException

sealed interface BookshelfUiState {
    data class Success(val books: List<Book>) : BookshelfUiState
    data class Error(@StringRes val messageRes: Int) : BookshelfUiState
    object Loading : BookshelfUiState
}

@OptIn(FlowPreview::class)
class BookshelfViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    var searchQuery: String by mutableStateOf(DEFAULT_QUERY)
        private set

    private val queryFlow = MutableStateFlow(DEFAULT_QUERY)
    private var lastQuery: String? = null
    private var loadJob: Job? = null

    init {
        getBooks()
        queryFlow
            .drop(1)
            .debounce(SEARCH_DEBOUNCE_MILLIS)
            .map { it.trim() }
            .filter { it.isNotEmpty() && it != lastQuery }
            .onEach { getBooks(it) }
            .launchIn(viewModelScope)
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
        queryFlow.value = query
    }

    fun retry() {
        getBooks(lastQuery ?: DEFAULT_QUERY)
    }

    fun getBooks(query: String = searchQuery.trim()) {
        if (query.isBlank()) return
        lastQuery = query
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try {
                BookshelfUiState.Success(booksRepository.getBooks(query))
            } catch (e: IOException) {
                BookshelfUiState.Error(R.string.loading_failed)
            } catch (e: HttpException) {
                BookshelfUiState.Error(
                    if (e.code() == NetworkBooksRepository.HTTP_TOO_MANY_REQUESTS) {
                        R.string.quota_exceeded
                    } else {
                        R.string.loading_failed
                    }
                )
            } catch (e: SerializationException) {
                BookshelfUiState.Error(R.string.loading_failed)
            }
        }
    }

    companion object {
        const val DEFAULT_QUERY = "jazz history"
        const val SEARCH_DEBOUNCE_MILLIS = 500L

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val booksRepository = application.container.booksRepository
                BookshelfViewModel(booksRepository = booksRepository)
            }
        }
    }
}
