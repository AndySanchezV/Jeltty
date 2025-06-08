package es.etg.dam.pmdmas.jeltty.data.remote.model

data class MealListResponse(
    val meals: List<MealDto>?
)

data class MealDto(
    val idMeal: String?,
    val strMeal: String?,
    val strInstructions: String?,
    val strMealThumb: String?
) 