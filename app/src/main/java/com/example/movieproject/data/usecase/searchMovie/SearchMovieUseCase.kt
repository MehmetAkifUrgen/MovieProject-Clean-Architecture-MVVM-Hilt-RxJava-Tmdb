package com.example.movieproject.data.usecase.searchMovie

import com.example.movieproject.base.BaseUseCase
import com.example.movieproject.data.repository.popular.PopularRepository
import com.example.movieproject.data.repository.search.SearchRepository
import com.example.movieproject.data.response.popular.PopularResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) : BaseUseCase<PopularResponse>() {

    private lateinit var query : String

    fun getQuery(querys: String) {
        query=querys
    }
    override fun buildUseCaseSingle(): Single<PopularResponse> {
        return searchRepository.searchMovie(query)
    }
}