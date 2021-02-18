package com.ar.newjetpack2021.repository

import com.ar.newjetpack2021.models.dto.RecipeDto
import com.ar.newjetpack2021.models.ui.RecipeMO

interface NetworkRepository {
    suspend fun search(token: String, page: Int, query: String) : RecipeDto
}