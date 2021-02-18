package com.ar.newjetpack2021.repository

import com.ar.newjetpack2021.models.dto.RecipeDto
import com.ar.newjetpack2021.models.ui.RecipeMO
import com.ar.newjetpack2021.network.RetrofitService

class NetworkRepository_Impl
constructor(private val retrofitService: RetrofitService) : NetworkRepository {

    override suspend fun search(token: String, page: Int, query: String): RecipeDto {
        return retrofitService.search(token = token, page = page, query)
    }

}