package com.example.demoproject.dashboard

import com.google.gson.annotations.SerializedName

data class Coffee(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val imageUrl: String
)
