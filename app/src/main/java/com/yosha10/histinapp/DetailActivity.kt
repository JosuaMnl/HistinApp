package com.yosha10.histinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yosha10.histinapp.databinding.ActivityDetailBinding
import com.yosha10.histinapp.databinding.ActivityMainBinding

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

    }
}