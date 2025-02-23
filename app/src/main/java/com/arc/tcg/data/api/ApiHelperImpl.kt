package com.arc.tcg.data.api

import com.arc.tcg.data.model.TCGCard
import com.arc.tcg.data.model.TCGCardDetail
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getCards(): Response<List<TCGCard>> = apiService.getCards()

    override suspend fun getCard(id: String?): Response<TCGCardDetail> = apiService.getCard(id)
}