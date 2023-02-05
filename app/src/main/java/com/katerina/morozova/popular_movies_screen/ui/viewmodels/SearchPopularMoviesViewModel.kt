package com.katerina.morozova.popular_movies_screen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkMovieResponse
import com.katerina.morozova.popular_movies_screen.domain.interactors.SearchPopularMoviesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPopularMoviesViewModel @Inject constructor(
    private val interactor: SearchPopularMoviesInteractor
) : ViewModel() {

    private var _searchedMovieModelResponse =
        MutableLiveData<NetworkMovieResponse<List<MovieModel>>>()
    val searchedMovieModelResponse: LiveData<NetworkMovieResponse<List<MovieModel>>> =
        _searchedMovieModelResponse

    fun fetchSearchedMovies(keyword: String) {
        viewModelScope.launch {
            interactor.getSearchedMovies(keyword).collect {
                _searchedMovieModelResponse.postValue(it)
            }
        }
    }
}