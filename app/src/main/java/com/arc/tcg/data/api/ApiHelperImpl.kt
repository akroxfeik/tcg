package com.arc.tcg.data.api

import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.data.model.CardBriefDetails
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getCards(name: String?): Response<List<CardBrief>> = apiService.getCards(name)

    override suspend fun getCard(id: String?): Response<CardBriefDetails> = apiService.getCard(id)
}