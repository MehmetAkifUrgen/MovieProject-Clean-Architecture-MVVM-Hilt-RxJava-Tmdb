package com.example.movieproject.data.api


import com.example.movieproject.data.response.casting.CastResponse
import com.example.movieproject.data.response.genre.GenreResponse
import com.example.movieproject.data.response.popular.PopularDetailsResponse
import com.example.movieproject.data.response.popular.PopularResponse
import com.example.movieproject.data.response.upcoming.UpComingResponse
import com.example.movieproject.data.response.watch.WatchResponse
import com.example.movieproject.utils.Constants.api_key
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceInterface {

    @GET("movie/popular?api_key=$api_key&language=en-US")
    fun getPopulars(@Query("page") page:Int): Flow<PopularResponse>

    @GET("movie/upcoming?api_key=$api_key&language=en-US&page=1")
    fun getUpComing(): Flow<UpComingResponse>

    @GET("movie/{id}?api_key=$api_key&language=tr-TR")
    fun getPopularDetails(@Path("id") id: String): Flow<PopularDetailsResponse>

    @GET("movie/{id}/credits?api_key=$api_key&language=tr-TR")
    fun getCast(@Path("id") id: String): Flow<CastResponse>

    @GET("movie/{id}/watch/providers?api_key=$api_key")
    fun getWatch(@Path("id") id: String): Flow<WatchResponse>

    @GET("search/movie?api_key=$api_key&language=en-US&page=1&include_adult=false")
    fun searchMovie(@Query("query") search: String): Flow<PopularResponse>

    @GET("genre/movie/list?api_key=$api_key&language=en-US")
    fun getGenres() : Flow<GenreResponse>

    @GET("discover/movie?api_key=$api_key&language=en-US&sort_by=popularity.desc&include_adult=false&page=1")
    fun getDiscover(@Query("with_genres") genre: String): Flow<PopularResponse>

}
