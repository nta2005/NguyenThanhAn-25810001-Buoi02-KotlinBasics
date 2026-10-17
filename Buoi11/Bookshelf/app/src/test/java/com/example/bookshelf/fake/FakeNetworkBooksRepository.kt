package com.example.bookshelf.fake

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book

class FakeNetworkBooksRepository(
    var error: Exception? = null
) : BooksRepository {
    val queries = mutableListOf<String>()

    override suspend fun getBooks(query: String): List<Book> {
        queries.add(query)
        error?.let { throw it }
        return if (query == FakeDataSource.EMPTY_QUERY) emptyList() else FakeDataSource.books
    }
}
