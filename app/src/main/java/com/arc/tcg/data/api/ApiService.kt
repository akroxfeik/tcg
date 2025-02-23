package com.arc.tcg.data.api

import com.arc.tcg.data.model.TCGCard
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("en/cards")
    suspend fun getCards(): Response<List<TCGCard>>
}