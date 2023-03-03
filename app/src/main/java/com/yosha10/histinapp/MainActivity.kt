package com.yosha10.histinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHistorySites: RecyclerView
    private val list = ArrayList<HistorySites>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHistorySites = findViewById(R.id.rv_history)
        rvHistorySites.setHasFixedSize(true)

        list.addAll(getListHistorySites())
        showRecyclerList()

    }

    private fun getListHistorySites(): ArrayList<HistorySites> {
        val dataName = resources.getStringArray(R.array.data_name_sites)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_image)
        val dataDate = resources.getStringArray(R.array.data_date_of_build)
        val dataCity = resources.getStringArray(R.array.data_city)
        val listHistorySites = ArrayList<HistorySites>()
        for (i in dataName.indices){
            val historySites = HistorySites(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataDate[i], dataCity[i])
            listHistorySites.add(historySites)
        }
        return listHistorySites
    }

    private fun showRecyclerList(){
        rvHistorySites.layoutManager = LinearLayoutManager(this)
        val listHistorySitesAdapter = ListHistorySitesAdapter(list)
        rvHistorySites.adapter = listHistorySitesAdapter
    }
}