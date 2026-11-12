package com.example.lab2mobile.ui

import com.example.lab2mobile.data.Artwork

/**
 * Перелистывание коллекции: текущий индекс и доступность кнопок «назад» и «вперёд».
 * Activity хранит только индекс, остальное вычисляется здесь.
 */
class ArtworkGallery(
    private val artworks: List<Artwork>,
    startIndex: Int = 0
) {

    init {
        require(artworks.isNotEmpty()) { "Gallery needs at least one artwork" }
    }

    var currentIndex: Int = startIndex.coerceIn(0, artworks.lastIndex)
        private set

    val size: Int
        get() = artworks.size

    val current: Artwork
        get() = artworks[currentIndex]

    val hasPrevious: Boolean
        get() = currentIndex > 0

    val hasNext: Boolean
        get() = currentIndex < artworks.lastIndex

    fun moveToPrevious() {
        if (hasPrevious) currentIndex--
    }

    fun moveToNext() {
        if (hasNext) currentIndex++
    }
}
