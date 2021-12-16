package com.example.innopolisonlinecinema.features.movies_list_screen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.base.setAdapterAndCleanupOnDetachFromWindow
import com.example.innopolisonlinecinema.base.setData
import com.example.innopolisonlinecinema.databinding.FragmentMoviesListBinding
import com.example.innopolisonlinecinema.features.movies_list_screen.ui.adapter.movieAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private val binding: FragmentMoviesListBinding by viewBinding(FragmentMoviesListBinding::bind)
    private val viewModel: MoviesListViewModel by viewModel()
    private val movieAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ListDelegationAdapter(movieAdapterDelegate { movie ->
            viewModel.processUiEvent(UIEvent.OnMovieClick(movie))
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun initAdapter() {
        binding.moviesList.apply {
            setAdapterAndCleanupOnDetachFromWindow(movieAdapter)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        movieAdapter.items = viewModel.viewState.value?.movies
    }

    private fun render(viewState: ViewState) {
        movieAdapter.setData(viewState.movies)
    }
}