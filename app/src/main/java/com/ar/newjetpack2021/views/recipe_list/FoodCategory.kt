package com.ar.newjetpack2021.views.recipe_list

enum class FoodCategory(val value: String) {
    CHICKEN("chicken"),
    BEEF("beef"),
    SOUP("soup"),
    VEGETARIAN("vegetarian"),
    MILK("milk"),
    VEGAN("vegan"),
    PIZZA("pizza"),
    DONUT("donut")
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(FoodCategory.CHICKEN,
        FoodCategory.BEEF,
        FoodCategory.SOUP,
        FoodCategory.VEGETARIAN,
        FoodCategory.MILK,
        FoodCategory.VEGAN,
        FoodCategory.PIZZA,
        FoodCategory.DONUT)
}

fun getFoodCategory(category: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[category]
}