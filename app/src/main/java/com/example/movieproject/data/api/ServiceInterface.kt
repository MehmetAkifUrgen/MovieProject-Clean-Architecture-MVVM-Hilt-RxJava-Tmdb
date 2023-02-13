package com.example.movieproject.data.api

import com.example.movieproject.data.response.casting.CastResponse
import com.example.movieproject.data.response.popular.PopularResponse
import com.example.movieproject.data.response.popular.PopularDetailsResponse
import com.example.movieproject.data.response.upcoming.UpComingResponse
import com.example.movieproject.utils.Constants.api_key
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceInterface {

    @GET("movie/popular?api_key=$api_key&language=en-US&page=1")
    fun getPopulars(): Single<PopularResponse>

    @GET("movie/upcoming?api_key=$api_key&language=en-US&page=1")
    fun getUpComing(): Single<UpComingResponse>

    @GET("movie/{id}?api_key=$api_key&language=en-US")
    fun getPopularDetails(@Path("id") id: String): Single<PopularDetailsResponse>

    @GET("movie/{id}/credits?api_key=$api_key&language=en-US")
    fun getCast(@Path("id") id: String): Single<CastResponse>

}