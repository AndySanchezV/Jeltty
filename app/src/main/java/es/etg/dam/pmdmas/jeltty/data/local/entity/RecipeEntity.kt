package es.etg.dam.pmdmas.jeltty.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val ingredients: String,
    val description: String,
    val imageUrl: String? = null
) 