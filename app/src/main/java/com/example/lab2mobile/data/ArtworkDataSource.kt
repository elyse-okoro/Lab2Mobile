package com.example.lab2mobile.data

import com.example.lab2mobile.R

/**
 * Коллекция картин русских художников XIX века (общественное достояние), по годам написания.
 */
object ArtworkDataSource {

    val artworks: List<Artwork> = listOf(
        Artwork(
            imageRes = R.drawable.aivazovsky_ninth_wave,
            titleRes = R.string.artwork_ninth_wave_title,
            artistRes = R.string.artist_aivazovsky,
            year = 1850,
            museumRes = R.string.museum_russian,
            descriptionRes = R.string.artwork_ninth_wave_description
        ),
        Artwork(
            imageRes = R.drawable.savrasov_rooks,
            titleRes = R.string.artwork_rooks_title,
            artistRes = R.string.artist_savrasov,
            year = 1871,
            museumRes = R.string.museum_tretyakov,
            descriptionRes = R.string.artwork_rooks_description
        ),
        Artwork(
            imageRes = R.drawable.kuindzhi_moonlit_night,
            titleRes = R.string.artwork_moonlit_night_title,
            artistRes = R.string.artist_kuindzhi,
            year = 1880,
            museumRes = R.string.museum_russian,
            descriptionRes = R.string.artwork_moonlit_night_description
        ),
        Artwork(
            imageRes = R.drawable.shishkin_morning_pine_forest,
            titleRes = R.string.artwork_pine_forest_title,
            artistRes = R.string.artist_shishkin_savitsky,
            year = 1889,
            museumRes = R.string.museum_tretyakov,
            descriptionRes = R.string.artwork_pine_forest_description
        ),
        Artwork(
            imageRes = R.drawable.vasnetsov_bogatyri,
            titleRes = R.string.artwork_bogatyri_title,
            artistRes = R.string.artist_vasnetsov,
            year = 1898,
            museumRes = R.string.museum_tretyakov,
            descriptionRes = R.string.artwork_bogatyri_description
        )
    )
}
