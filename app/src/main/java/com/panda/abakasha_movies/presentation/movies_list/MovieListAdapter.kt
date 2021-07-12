package com.panda.abakasha_movies.presentation.movies_list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panda.abakasha_movies.R
import com.panda.abakasha_movies.data.model.Results
import com.panda.abakasha_movies.databinding.MovieListItemBinding

//Adapter class for populating the recycler view
class MovieListAdapter() : RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {

    private val movieList = ArrayList<Results>()

    fun setList(movies: List<Results>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    //View holder class for each item in recycler view.
    inner class MyViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Results) {
            binding.titleTextView.text = movie.display_title
            binding.descriptionTextView.text = movie.summary_short
            val thumbnailURL = movie.multimedia?.src
            thumbnailURL?.let {
                Glide.with(binding.imageView.context)
                    .load(thumbnailURL)
                    .into(binding.imageView)
            }
            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(movie)
                }
            }

        }
    }

    private var onItemClickListener: ((Results) -> Unit)? = null

    fun setOnItemClickListener(listener: (Results) -> Unit) {
        onItemClickListener = listener
    }
}