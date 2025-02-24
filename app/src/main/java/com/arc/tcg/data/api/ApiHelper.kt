package com.arc.tcg.data.api

import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.data.model.CardBriefDetails
import retrofit2.Response

interface ApiHelper {
    suspend fun getCards(name: String?): Response<List<CardBrief>>

    suspend fun getCard(id: String?): Response<CardBriefDetails>
}