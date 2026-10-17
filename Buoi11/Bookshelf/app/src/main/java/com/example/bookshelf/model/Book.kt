package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookSearchResponse(
    val items: List<BookItem> = emptyList()
)

@Serializable
data class BookItem(
    val id: String
)

@Serializable
data class Volume(
    val id: String,
    val volumeInfo: VolumeInfo = VolumeInfo()
)

@Serializable
data class VolumeInfo(
    val title: String = "",
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)

data class Book(
    val id: String,
    val title: String,
    val thumbnailUrl: String
)
