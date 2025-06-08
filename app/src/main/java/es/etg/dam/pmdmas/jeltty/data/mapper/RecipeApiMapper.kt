package es.etg.dam.pmdmas.jeltty.data.mapper

import es.etg.dam.pmdmas.jeltty.data.remote.model.MealDto
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe

fun MealDto.toDomain(): Recipe = Recipe(
    id = idMeal?.toIntOrNull() ?: 0,
    title = strMeal ?: "",
    ingredients = "",
    description = strInstructions ?: "",
    imageUrl = strMealThumb
) 