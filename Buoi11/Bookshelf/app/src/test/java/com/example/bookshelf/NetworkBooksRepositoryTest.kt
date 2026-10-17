package com.example.bookshelf

import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.fake.FakeBookshelfApiService
import com.example.bookshelf.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.HttpException

class NetworkBooksRepositoryTest {
    @Test
    fun networkBooksRepository_getBooks_verifyBookList() = runTest {
        val repository = NetworkBooksRepository(bookshelfApiService = FakeBookshelfApiService())
        assertEquals(FakeDataSource.books, repository.getBooks("jazz history"))
    }

    @Test
    fun networkBooksRepository_getBooks_verifyDuplicateIdsRequestedOnce() = runTest {
        val apiService = FakeBookshelfApiService()
        NetworkBooksRepository(bookshelfApiService = apiService).getBooks("jazz history")
        assertEquals(listOf("id1", "id2", "id3", FakeDataSource.NOT_FOUND_ID), apiService.requestedVolumeIds)
    }

    @Test(expected = HttpException::class)
    fun networkBooksRepository_volumeQuotaExceeded_verifyExceptionThrown() = runTest {
        val apiService = FakeBookshelfApiService(
            volumeErrorCode = NetworkBooksRepository.HTTP_TOO_MANY_REQUESTS
        )
        NetworkBooksRepository(bookshelfApiService = apiService).getBooks("jazz history")
    }
}
