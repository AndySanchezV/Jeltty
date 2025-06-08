package es.etg.dam.pmdmas.jeltty.domain.usecase

import es.etg.dam.pmdmas.jeltty.domain.repository.RecipeRepository

class RemoveFavoriteUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(id: Int) = repository.removeFavorite(id)
} 