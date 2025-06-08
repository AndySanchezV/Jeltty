package es.etg.dam.pmdmas.jeltty.data.repository

import es.etg.dam.pmdmas.jeltty.data.local.RecipeDao
import es.etg.dam.pmdmas.jeltty.data.mapper.toDomain
import es.etg.dam.pmdmas.jeltty.data.mapper.toEntity
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe
import es.etg.dam.pmdmas.jeltty.domain.repository.RecipeRepository
import es.etg.dam.pmdmas.jeltty.data.remote.RecipeRemoteDataSource
import es.etg.dam.pmdmas.jeltty.data.mapper.toDomain as apiToDomain

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {
    private val remoteDataSource = RecipeRemoteDataSource()
    override suspend fun getFavorites(): List<Recipe> = dao.getAll().map { it.toDomain() }
    override suspend fun addFavorite(recipe: Recipe) = dao.insert(recipe.toEntity())
    override suspend fun removeFavorite(id: Int) = dao.deleteById(id)
    override suspend fun getRemoteRecipes(): List<Recipe> = remoteDataSource.getRecipes().map { it.apiToDomain() }
} 