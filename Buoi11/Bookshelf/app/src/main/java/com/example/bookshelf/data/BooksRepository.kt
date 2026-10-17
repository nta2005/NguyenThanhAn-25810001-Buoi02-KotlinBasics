package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Volume
import com.example.bookshelf.network.BookshelfApiService
import kotlinx.serialization.SerializationException
import retrofit2.HttpException

interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

class NetworkBooksRepository(
    private val bookshelfApiService: BookshelfApiService
) : BooksRepository {
    override suspend fun getBooks(query: String): List<Book> {
        val books = mutableListOf<Book>()
        bookshelfApiService.searchBooks(query).items.distinctBy { it.id }.forEach { item ->
            val volume = getVolumeOrNull(item.id) ?: return@forEach
            val thumbnail = volume.volumeInfo.imageLinks?.thumbnail ?: return@forEach
            books.add(
                Book(
                    id = volume.id,
                    title = volume.volumeInfo.title,
                    thumbnailUrl = thumbnail.replace("http://", "https://")
                )
            )
        }
        return books
    }

    private suspend fun getVolumeOrNull(id: String): Volume? {
        return try {
            bookshelfApiService.getVolume(id)
        } catch (e: HttpException) {
            if (e.code() == HTTP_TOO_MANY_REQUESTS) throw e
            null
        } catch (e: SerializationException) {
            null
        }
    }

    companion object {
        const val HTTP_TOO_MANY_REQUESTS = 429
    }
}
