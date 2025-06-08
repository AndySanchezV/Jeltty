package es.etg.dam.pmdmas.jeltty.domain.usecase

import es.etg.dam.pmdmas.jeltty.domain.model.Recipe
import es.etg.dam.pmdmas.jeltty.domain.repository.RecipeRepository

class AddFavoriteUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(recipe: Recipe) = repository.addFavorite(recipe)
} 