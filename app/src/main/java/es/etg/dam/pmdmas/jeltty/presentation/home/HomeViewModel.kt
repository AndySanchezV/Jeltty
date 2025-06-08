package es.etg.dam.pmdmas.jeltty.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.etg.dam.pmdmas.jeltty.JelttyApp
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as JelttyApp).repository
    private val _recipes = MutableLiveData<List<Recipe>>(listOf(
        //probar si funciona y luego cargar
        Recipe(1, "Tortilla de patatas", "Huevos, patatas, cebolla...", "Preparación de ejemplo..."),
        Recipe(2, "Gazpacho", "Tomate, pepino, pan...", "Preparación de ejemplo..."),
        Recipe(3, "Paella", "Arroz, mariscos, verduras...", "Preparación de ejemplo...")
    ))
    val recipes: LiveData<List<Recipe>> = _recipes

    init {
        loadRemoteRecipes()
    }

    fun loadRemoteRecipes() {
        viewModelScope.launch {
            try {
                val remoteRecipes = repository.getRemoteRecipes()
                _recipes.value = remoteRecipes
            } catch (e: Exception) {
                // logear el error
            }
        }
    }

    fun addToFavorites(recipe: Recipe) {
        viewModelScope.launch {
            repository.addFavorite(recipe)
        }
    }
} 