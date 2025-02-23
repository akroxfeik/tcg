package com.arc.tcg.data.api

import com.arc.tcg.data.model.TCGCard
import retrofit2.Response

interface ApiHelper {
    suspend fun getCards(): Response<List<TCGCard>>
}