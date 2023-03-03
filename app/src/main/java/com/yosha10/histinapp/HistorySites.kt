package com.yosha10.histinapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistorySites(
    val name: String,
    val description: String,
    val photo: Int,
    val date: String,
    val location: String
) : Parcelable