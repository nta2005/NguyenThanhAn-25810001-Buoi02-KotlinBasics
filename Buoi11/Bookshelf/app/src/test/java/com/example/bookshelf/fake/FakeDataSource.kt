package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BookSearchResponse
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.Volume
import com.example.bookshelf.model.VolumeInfo
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

object FakeDataSource {
    const val EMPTY_QUERY = "no result"
    const val NOT_FOUND_ID = "id4"

    val searchResponse = BookSearchResponse(
        items = listOf(
            BookItem(id = "id1"),
            BookItem(id = "id2"),
            BookItem(id = "id1"),
            BookItem(id = "id3"),
            BookItem(id = NOT_FOUND_ID)
        )
    )

    val volumes = mapOf(
        "id1" to Volume(
            id = "id1",
            volumeInfo = VolumeInfo(
                title = "Book 1",
                imageLinks = ImageLinks(thumbnail = "http://books.google.com/1.jpg")
            )
        ),
        "id2" to Volume(
            id = "id2",
            volumeInfo = VolumeInfo(
                title = "Book 2",
                imageLinks = ImageLinks(thumbnail = "https://books.google.com/2.jpg")
            )
        ),
        "id3" to Volume(
            id = "id3",
            volumeInfo = VolumeInfo(title = "Book 3", imageLinks = null)
        )
    )

    val books = listOf(
        Book(id = "id1", title = "Book 1", thumbnailUrl = "https://books.google.com/1.jpg"),
        Book(id = "id2", title = "Book 2", thumbnailUrl = "https://books.google.com/2.jpg")
    )

    fun httpException(code: Int): HttpException {
        return HttpException(Response.error<Any>(code, "".toResponseBody(null)))
    }
}
