package com.arc.tcg.data.repository

import com.arc.tcg.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getCards(name: String?) =  apiHelper.getCards(name)

    suspend fun getCard(id: String?) = apiHelper.getCard(id)
}