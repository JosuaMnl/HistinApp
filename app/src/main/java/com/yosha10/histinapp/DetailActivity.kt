package com.yosha10.histinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yosha10.histinapp.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHistorySites = intent.getParcelableExtra(ListHistorySitesAdapter.KEY_HISTORY_SITES) as HistorySites?
        binding.tvNameDetail.text = dataHistorySites?.name
        binding.tvCityDetail.text = dataHistorySites?.location
        binding.tvDescriptionDetail.text = dataHistorySites?.description
        binding.tvDateDetail.text = dataHistorySites?.date
        dataHistorySites?.photo?.let { binding.imgDetail.setImageResource(it) }

        binding.actionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                val historicalSitesName = dataHistorySites?.name
                val historicalSitesDescription = dataHistorySites?.description
                putExtra(Intent.EXTRA_TEXT, "$historicalSitesName\n\nDeskripsi :\n$historicalSitesDescription")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, "Tempat Bersejarah di Indonesia")
            startActivity(shareIntent)
        }
    }
}