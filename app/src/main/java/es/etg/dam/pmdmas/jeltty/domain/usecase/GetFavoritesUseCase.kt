package es.etg.dam.pmdmas.jeltty.domain.usecase

import es.etg.dam.pmdmas.jeltty.domain.repository.RecipeRepository

class GetFavoritesUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke() = repository.getFavorites()
} 