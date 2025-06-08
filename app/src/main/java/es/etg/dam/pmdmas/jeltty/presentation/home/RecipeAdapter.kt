package es.etg.dam.pmdmas.jeltty.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.etg.dam.pmdmas.jeltty.databinding.ItemRecipeBinding
import es.etg.dam.pmdmas.jeltty.domain.model.Recipe

class RecipeAdapter(
    private val onClick: (Recipe) -> Unit,
    private val onDelete: ((Recipe) -> Unit)? = null
) : ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.recipeTitle.text = recipe.title
            if (recipe.imageUrl != null) {
                Glide.with(binding.root).load(recipe.imageUrl).into(binding.recipeImage)
            } else {
                binding.recipeImage.setImageDrawable(null)
            }
            if (onDelete != null) {
                binding.deleteButton.setOnClickListener { onDelete.invoke(recipe) }
                binding.deleteButton.visibility = android.view.View.VISIBLE
                binding.root.setOnClickListener(null)
            } else {
                binding.deleteButton.visibility = android.view.View.GONE
                binding.root.setOnClickListener { onClick(recipe) }
            }
        }
    }
} 