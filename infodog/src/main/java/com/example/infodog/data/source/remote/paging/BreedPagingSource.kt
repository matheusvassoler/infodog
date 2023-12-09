package com.example.infodog.data.source.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.infodog.data.model.Breed
import com.example.infodog.data.source.remote.RetrofitClientFactory
import com.example.infodog.data.source.remote.RetrofitService
import retrofit2.HttpException
import java.io.IOException

class BreedPagingSource(
    private val api: RetrofitClientFactory
) : PagingSource<Int, Breed>() {

    private val retrofitService by lazy {
        api.createRetrofitService(
            "https://api.thedogapi.com/",
            RetrofitService::class.java
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Breed>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Breed> {
        return try {
            val currentPage = params.key ?: 0
            val response = retrofitService.getBreeds(currentPage)
            val data: List<Breed>? = response.body()

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (data?.isEmpty() == true) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
