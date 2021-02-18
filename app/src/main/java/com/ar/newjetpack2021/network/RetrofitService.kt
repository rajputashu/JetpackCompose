package com.ar.newjetpack2021.network

import com.ar.newjetpack2021.models.dto.RecipeDto
import com.ar.newjetpack2021.models.ui.RecipeMO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeDto // Change this RecipeDTO
}