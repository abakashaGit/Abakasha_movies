package com.panda.abakasha_movies.presentation.movies_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panda.abakasha_movies.R
import com.panda.abakasha_movies.data.api.MovieApiService
import com.panda.abakasha_movies.data.repository.MovieRepositoryImpl
import com.panda.abakasha_movies.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import com.panda.abakasha_movies.databinding.FragmentMovieListBinding
import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase
import com.panda.abakasha_movies.presentation.MainActivity
import com.panda.abakasha_movies.presentation.di.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MovieListFragment : Fragment() {

    @Inject
    lateinit var factory: MovieListViewModelFactory
    private lateinit var movieViewModel: MovieListViewModel
    private lateinit var adapter: MovieListAdapter
    private lateinit var binding:FragmentMovieListBinding
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieListBinding.bind(view)
        (activity?.application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel= ViewModelProvider(this,factory)
            .get(MovieListViewModel::class.java)

        initRecyclerView()
    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun initRecyclerView(){
        binding.movieRecyclerview.layoutManager = LinearLayoutManager(activity)
        adapter = MovieListAdapter()

        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_movie",it)
            }
            findNavController().navigate(
                R.id.action_movieListFragment_to_movieDetailFragment,
                bundle
            )
        }

        binding.movieRecyclerview.adapter = adapter
        displayMovies()
    }

    private fun displayMovies(){
        showProgressBar()
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            hideProgressBar()
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
               // binding.movieProgressBar.visibility = View.GONE
            }else{
                //binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(activity,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }

}

