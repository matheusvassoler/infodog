package com.example.infodog.data.source.remote

import com.example.infodog.BuildConfig
import com.example.infodog.data.model.Breed
import retrofit2.http.GET
import retrofit2.http.Query

private const val DEFAULT_PAGE = 0
private const val DEFAULT_LIMIT = 20

interface RetrofitService {

    @GET("v1/breeds")
    suspend fun getBreeds(
        @Query("page") page: Int = DEFAULT_PAGE,
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("api_key") apikey: String = BuildConfig.API_KEY
    ): List<Breed>
}
