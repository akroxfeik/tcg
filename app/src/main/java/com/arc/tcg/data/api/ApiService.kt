package com.arc.tcg.data.api

import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.data.model.CardBriefDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("en/cards")
    suspend fun getCards(@Query("name") name: String?): Response<List<CardBrief>>

    @GET("en/cards/{id}")
    suspend fun getCard(@Path("id") id: String?): Response<CardBriefDetails>
}