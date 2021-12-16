package com.example.innopolisonlinecinema.features.movies_list_screen.ui.adapter

import com.bumptech.glide.Glide
import com.example.innopolisonlinecinema.databinding.MovieItemBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun movieAdapterDelegate(onItemClick: (movie: MovieDomainModel) -> Unit) =
    adapterDelegateViewBinding<MovieDomainModel, MovieDomainModel, MovieItemBinding>(
        { layoutInflater, parent ->
            MovieItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.root.setOnClickListener {
            onItemClick(item)
        }

        bind {
            binding.apply {
                movieTitle.text = item.title
                Glide.with(context).load(item.posterPath).into(moviePoster)
            }
        }
    }