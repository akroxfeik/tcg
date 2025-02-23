package com.arc.tcg.data.api

import com.arc.tcg.data.model.TCGCard
import com.arc.tcg.data.model.TCGCardDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("en/cards")
    suspend fun getCards(): Response<List<TCGCard>>

    @GET("en/cards/{id}")
    suspend fun getCard(@Path("id") id: String): Response<TCGCardDetail>
}