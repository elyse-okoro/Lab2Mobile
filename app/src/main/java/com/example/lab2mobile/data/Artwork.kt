package com.example.lab2mobile.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Экспонат галереи. Тексты лежат в strings.xml, здесь только идентификаторы ресурсов.
 */
data class Artwork(
    @param:DrawableRes val imageRes: Int,
    @param:StringRes val titleRes: Int,
    @param:StringRes val artistRes: Int,
    val year: Int,
    @param:StringRes val museumRes: Int,
    @param:StringRes val descriptionRes: Int
)
