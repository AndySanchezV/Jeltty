package es.etg.dam.pmdmas.jeltty.domain.repository

import es.etg.dam.pmdmas.jeltty.domain.model.Recipe

interface RecipeRepository {
    suspend fun getFavorites(): List<Recipe>
    suspend fun addFavorite(recipe: Recipe)
    suspend fun removeFavorite(id: Int)
    suspend fun getRemoteRecipes(): List<Recipe>
} 