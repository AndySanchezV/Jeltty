package es.etg.dam.pmdmas.jeltty.presentation.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.etg.dam.pmdmas.jeltty.JelttyApp
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as JelttyApp).repository
    private val _favorites = MutableLiveData<List<Recipe>>()
    val favorites: LiveData<List<Recipe>> = _favorites

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = repository.getFavorites()
        }
    }

    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            repository.removeFavorite(id)
            loadFavorites()
        }
    }
} 