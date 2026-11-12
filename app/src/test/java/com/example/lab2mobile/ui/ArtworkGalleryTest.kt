package com.example.lab2mobile.ui

import com.example.lab2mobile.data.ArtworkDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ArtworkGalleryTest {

    private val artworks = ArtworkDataSource.artworks

    @Test
    fun firstArtwork_previousIsDisabled() {
        val gallery = ArtworkGallery(artworks)

        assertEquals(0, gallery.currentIndex)
        assertFalse(gallery.hasPrevious)
        assertTrue(gallery.hasNext)
    }

    @Test
    fun moveToNext_stopsAtLastArtwork() {
        val gallery = ArtworkGallery(artworks)

        repeat(artworks.size + 2) { gallery.moveToNext() }

        assertEquals(artworks.lastIndex, gallery.currentIndex)
        assertFalse(gallery.hasNext)
        assertTrue(gallery.hasPrevious)
    }

    @Test
    fun moveToPrevious_onFirstArtwork_staysInPlace() {
        val gallery = ArtworkGallery(artworks)

        gallery.moveToPrevious()

        assertEquals(0, gallery.currentIndex)
    }

    @Test
    fun restoredIndex_isUsedAfterRotation() {
        val gallery = ArtworkGallery(artworks, startIndex = 2)

        assertEquals(artworks[2], gallery.current)
        assertTrue(gallery.hasPrevious)
        assertTrue(gallery.hasNext)
    }

    @Test
    fun brokenSavedIndex_isClamped() {
        assertEquals(artworks.lastIndex, ArtworkGallery(artworks, startIndex = 99).currentIndex)
        assertEquals(0, ArtworkGallery(artworks, startIndex = -3).currentIndex)
    }

    @Test
    fun collection_hasFiveDifferentArtworks() {
        assertEquals(5, artworks.size)
        assertEquals(artworks.size, artworks.map { it.imageRes }.toSet().size)
        assertEquals(artworks.sortedBy { it.year }, artworks)
    }
}
