package com.arc.tcg.data.model

import com.squareup.moshi.Json

data class CardBrief (
    @Json(name = "id")
    val id: String,
    @Json(name = "localId")
    val localId: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: String
)
