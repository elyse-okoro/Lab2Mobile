package com.example.lab2mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import com.example.lab2mobile.data.ArtworkDataSource
import com.example.lab2mobile.databinding.ActivityMainBinding
import com.example.lab2mobile.ui.ArtworkGallery

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gallery: ArtworkGallery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()

        // после поворота экрана индекс приходит из Bundle, сохранённого в onSaveInstanceState
        val startIndex = savedInstanceState?.getInt(KEY_ARTWORK_INDEX) ?: 0
        gallery = ArtworkGallery(ArtworkDataSource.artworks, startIndex)

        binding.previousButton.setOnClickListener {
            gallery.moveToPrevious()
            showCurrentArtwork()
        }
        binding.nextButton.setOnClickListener {
            gallery.moveToNext()
            showCurrentArtwork()
        }
        showCurrentArtwork()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_ARTWORK_INDEX, gallery.currentIndex)
    }

    private fun showCurrentArtwork() {
        val artwork = gallery.current
        binding.artworkImage.setImageResource(artwork.imageRes)
        fitFrameToImage()
        binding.artworkImage.contentDescription = getString(artwork.descriptionRes)
        binding.artworkTitle.setText(artwork.titleRes)
        binding.artworkArtist.setText(artwork.artistRes)
        binding.artworkDetails.text =
            getString(R.string.artwork_details, artwork.year, getString(artwork.museumRes))
        binding.positionText.text =
            getString(R.string.artwork_position, gallery.currentIndex + 1, gallery.size)
        binding.previousButton.isEnabled = gallery.hasPrevious
        binding.nextButton.isEnabled = gallery.hasNext
    }

    /**
     * Рамка принимает пропорции картины: горизонтальная и вертикальная работы
     * занимают всё доступное место без пустых полей внутри рамки.
     */
    private fun fitFrameToImage() {
        val image = binding.artworkImage.drawable ?: return
        binding.artworkFrame.updateLayoutParams<ConstraintLayout.LayoutParams> {
            dimensionRatio = "${image.intrinsicWidth}:${image.intrinsicHeight}"
        }
    }

    private fun applyWindowInsets() {
        val basePadding = binding.main.paddingLeft
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(
                left = basePadding + bars.left,
                top = basePadding + bars.top,
                right = basePadding + bars.right,
                bottom = basePadding + bars.bottom
            )
            insets
        }
    }

    private companion object {
        const val KEY_ARTWORK_INDEX = "artwork_index"
    }
}
