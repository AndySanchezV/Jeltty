package es.etg.dam.pmdmas.jeltty

import android.app.Application
import es.etg.dam.pmdmas.jeltty.data.local.RecipeDatabase
import es.etg.dam.pmdmas.jeltty.data.repository.RecipeRepositoryImpl
import es.etg.dam.pmdmas.jeltty.domain.repository.RecipeRepository

class JelttyApp : Application() {
    lateinit var repository: RecipeRepository
        private set

    override fun onCreate() {
        super.onCreate()
        val db = RecipeDatabase.getDatabase(this)
        repository = RecipeRepositoryImpl(db.recipeDao())
    }
} 