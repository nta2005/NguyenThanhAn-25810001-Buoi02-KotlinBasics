package com.example.bookshelf.network

import com.example.bookshelf.model.BookSearchResponse
import com.example.bookshelf.model.Volume
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse

    @GET("volumes/{id}")
    suspend fun getVolume(@Path("id") id: String): Volume
}
