package es.etg.dam.pmdmas.jeltty.data.remote

import es.etg.dam.pmdmas.jeltty.data.remote.model.MealDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeRemoteDataSource {
    private val api: RecipeApiService = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")//spoonacular no funciona
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RecipeApiService::class.java)

    suspend fun getRecipes(): List<MealDto> {
        return api.searchRecipes().meals ?: emptyList()
    }
} 