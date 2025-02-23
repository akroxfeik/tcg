package com.arc.tcg.data.api

import com.arc.tcg.data.model.Card
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getCards(): Response<List<Card>> = apiService.getCards()
}