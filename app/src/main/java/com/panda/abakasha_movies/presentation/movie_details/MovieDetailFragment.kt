package com.panda.abakasha_movies.presentation.movie_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.panda.abakasha_movies.R
import com.panda.abakasha_movies.data.model.Results
import com.panda.abakasha_movies.databinding.FragmentMovieDetailBinding
// Movie detail fragment for showing movie details.
class MovieDetailFragment : Fragment() {

    private lateinit var binding:FragmentMovieDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailBinding.inflate(inflater)
        val arg:Results = arguments?.getSerializable("selected_movie") as Results
        val desc = arg.display_title
        val image = arg.multimedia.src
        val shortDesc = arg.summary_short
        image?.let {
            Glide.with(binding.imageView.context)
                .load(image)
                .into(binding.imageView)
        }
        binding.titleTextView.text = desc
        binding.descriptionTextView.text = shortDesc

        return binding.root
    }

}