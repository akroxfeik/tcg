package com.arc.tcg.data.api

import com.arc.tcg.data.model.TCGCard
import com.arc.tcg.data.model.TCGCardDetail
import retrofit2.Response

interface ApiHelper {
    suspend fun getCards(): Response<List<TCGCard>>

    suspend fun getCard(id: String): Response<TCGCardDetail>
}