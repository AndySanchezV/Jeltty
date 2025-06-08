package es.etg.dam.pmdmas.jeltty.data.remote

import es.etg.dam.pmdmas.jeltty.data.remote.model.MealListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {
    @GET("search.php")
    suspend fun searchRecipes(@Query("s") query: String = ""): MealListResponse
} 