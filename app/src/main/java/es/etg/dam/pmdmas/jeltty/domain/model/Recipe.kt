package es.etg.dam.pmdmas.jeltty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val ingredients: String,
    val description: String,
    val imageUrl: String? = null
) : Parcelable 