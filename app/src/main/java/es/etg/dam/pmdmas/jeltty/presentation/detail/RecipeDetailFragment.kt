package es.etg.dam.pmdmas.jeltty.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import es.etg.dam.pmdmas.jeltty.databinding.FragmentRecipeDetailBinding
import es.etg.dam.pmdmas.jeltty.presentation.home.HomeViewModel
import es.etg.dam.pmdmas.jeltty.presentation.favorites.FavoritesViewModel

class RecipeDetailFragment : Fragment() {
    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!
    private val args: RecipeDetailFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val favoritesViewModel: FavoritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipe = args.recipe
        binding.recipeTitle.text = recipe.title
        binding.recipeDescription.text = recipe.description
        binding.addToFavorites.setOnClickListener {
            homeViewModel.addToFavorites(recipe)
            favoritesViewModel.loadFavorites()
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 