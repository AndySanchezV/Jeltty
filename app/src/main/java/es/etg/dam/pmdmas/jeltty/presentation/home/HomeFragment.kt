package es.etg.dam.pmdmas.jeltty.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import es.etg.dam.pmdmas.jeltty.R
import es.etg.dam.pmdmas.jeltty.databinding.FragmentHomeBinding
import es.etg.dam.pmdmas.jeltty.presentation.favorites.FavoritesViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(HomeViewModel::class.java)
        favoritesViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(FavoritesViewModel::class.java)
        binding.headerText.text = getString(R.string.user_header)
        val adapter = RecipeAdapter(
            onClick = { recipe ->
                val action = HomeFragmentDirections.actionHomeFragmentToRecipeDetailFragment(recipe)
                findNavController().navigate(action)
            }
        )
        binding.recipesRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recipesRecycler.adapter = adapter
        viewModel.recipes.observe(viewLifecycleOwner) { adapter.submitList(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 