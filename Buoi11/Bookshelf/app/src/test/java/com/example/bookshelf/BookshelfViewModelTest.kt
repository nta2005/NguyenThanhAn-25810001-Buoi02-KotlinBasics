package com.example.bookshelf

import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.fake.FakeDataSource
import com.example.bookshelf.fake.FakeNetworkBooksRepository
import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.BookshelfUiState
import com.example.bookshelf.ui.BookshelfViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.SerializationException
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class BookshelfViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookshelfViewModel_getBooks_verifyBookshelfUiStateSuccess() = runTest {
        val bookshelfViewModel = BookshelfViewModel(booksRepository = FakeNetworkBooksRepository())
        assertEquals(
            BookshelfUiState.Success(FakeDataSource.books),
            bookshelfViewModel.bookshelfUiState
        )
    }

    @Test
    fun bookshelfViewModel_typeQuickly_verifyOnlyLastQuerySearched() = runTest {
        val repository = FakeNetworkBooksRepository()
        val bookshelfViewModel = BookshelfViewModel(booksRepository = repository)
        bookshelfViewModel.updateSearchQuery("no")
        bookshelfViewModel.updateSearchQuery("no res")
        bookshelfViewModel.updateSearchQuery(FakeDataSource.EMPTY_QUERY)
        advanceTimeBy(BookshelfViewModel.SEARCH_DEBOUNCE_MILLIS - 1)
        assertEquals(listOf(BookshelfViewModel.DEFAULT_QUERY), repository.queries)
        advanceUntilIdle()
        assertEquals(
            listOf(BookshelfViewModel.DEFAULT_QUERY, FakeDataSource.EMPTY_QUERY),
            repository.queries
        )
        assertEquals(BookshelfUiState.Success(emptyList()), bookshelfViewModel.bookshelfUiState)
    }

    @Test
    fun bookshelfViewModel_searchBlankQuery_verifyRepositoryNotCalled() = runTest {
        val repository = FakeNetworkBooksRepository()
        val bookshelfViewModel = BookshelfViewModel(booksRepository = repository)
        bookshelfViewModel.updateSearchQuery("   ")
        advanceUntilIdle()
        bookshelfViewModel.getBooks()
        assertEquals(listOf(BookshelfViewModel.DEFAULT_QUERY), repository.queries)
        assertEquals(
            BookshelfUiState.Success(FakeDataSource.books),
            bookshelfViewModel.bookshelfUiState
        )
    }

    @Test
    fun bookshelfViewModel_searchSameQueryAfterSubmit_verifyNoDuplicateRequest() = runTest {
        val repository = FakeNetworkBooksRepository()
        val bookshelfViewModel = BookshelfViewModel(booksRepository = repository)
        bookshelfViewModel.updateSearchQuery(FakeDataSource.EMPTY_QUERY)
        bookshelfViewModel.getBooks()
        advanceUntilIdle()
        assertEquals(
            listOf(BookshelfViewModel.DEFAULT_QUERY, FakeDataSource.EMPTY_QUERY),
            repository.queries
        )
    }

    @Test
    fun bookshelfViewModel_networkError_verifyBookshelfUiStateError() = runTest {
        val bookshelfViewModel = BookshelfViewModel(
            booksRepository = FakeNetworkBooksRepository(error = IOException())
        )
        assertEquals(
            BookshelfUiState.Error(R.string.loading_failed),
            bookshelfViewModel.bookshelfUiState
        )
    }

    @Test
    fun bookshelfViewModel_quotaExceeded_verifyBookshelfUiStateQuotaError() = runTest {
        val bookshelfViewModel = BookshelfViewModel(
            booksRepository = FakeNetworkBooksRepository(
                error = FakeDataSource.httpException(NetworkBooksRepository.HTTP_TOO_MANY_REQUESTS)
            )
        )
        assertEquals(
            BookshelfUiState.Error(R.string.quota_exceeded),
            bookshelfViewModel.bookshelfUiState
        )
    }

    @Test
    fun bookshelfViewModel_serializationError_verifyBookshelfUiStateError() = runTest {
        val bookshelfViewModel = BookshelfViewModel(
            booksRepository = FakeNetworkBooksRepository(error = SerializationException())
        )
        assertEquals(
            BookshelfUiState.Error(R.string.loading_failed),
            bookshelfViewModel.bookshelfUiState
        )
    }

    @Test
    fun bookshelfViewModel_retryWithBlankQuery_verifyLastQuerySearchedAgain() = runTest {
        val repository = FakeNetworkBooksRepository(error = IOException())
        val bookshelfViewModel = BookshelfViewModel(booksRepository = repository)
        bookshelfViewModel.updateSearchQuery("")
        advanceUntilIdle()
        repository.error = null
        bookshelfViewModel.retry()
        assertEquals(
            listOf(BookshelfViewModel.DEFAULT_QUERY, BookshelfViewModel.DEFAULT_QUERY),
            repository.queries
        )
        assertEquals(
            BookshelfUiState.Success(FakeDataSource.books),
            bookshelfViewModel.bookshelfUiState
        )
    }
}
