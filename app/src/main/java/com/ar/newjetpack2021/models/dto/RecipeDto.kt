package com.ar.newjetpack2021.models.dto

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<RecipeResultDto>? = null
)

data class RecipeResultDto(
    @SerializedName("pk")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("featured_image")
    val featured_image: String? = null,
    @SerializedName("rating")
    val rating: Int? = null
)