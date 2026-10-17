package com.example.bookshelf.fake

import com.example.bookshelf.model.BookSearchResponse
import com.example.bookshelf.model.Volume
import com.example.bookshelf.network.BookshelfApiService

class FakeBookshelfApiService(
    private val volumeErrorCode: Int = 404
) : BookshelfApiService {
    val requestedVolumeIds = mutableListOf<String>()

    override suspend fun searchBooks(query: String): BookSearchResponse {
        return FakeDataSource.searchResponse
    }

    override suspend fun getVolume(id: String): Volume {
        requestedVolumeIds.add(id)
        return FakeDataSource.volumes[id] ?: throw FakeDataSource.httpException(volumeErrorCode)
    }
}
