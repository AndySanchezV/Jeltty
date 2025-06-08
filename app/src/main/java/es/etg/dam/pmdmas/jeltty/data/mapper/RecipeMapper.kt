package es.etg.dam.pmdmas.jeltty.data.mapper

import es.etg.dam.pmdmas.jeltty.data.local.entity.RecipeEntity
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe

fun RecipeEntity.toDomain() = Recipe(id, title, ingredients, description, imageUrl)
fun Recipe.toEntity() = RecipeEntity(id, title, ingredients, description, imageUrl) 