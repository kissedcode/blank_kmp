package dev.kissed.blankkmp.data

import dev.kissed.blankkmp.Constants

interface ImageRepository {
    fun getImageUrl(): String
}

internal class ImageRepositoryImpl : ImageRepository {
    override fun getImageUrl(): String {
        return Constants.arnoldImageUrl
    }
}