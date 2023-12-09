package com.example.infodog.data.repository.breed

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.infodog.data.model.Breed
import com.example.infodog.data.source.remote.paging.BreedPagingSource
import kotlinx.coroutines.flow.Flow

class BreedRemoteRepository(
    private val breedPagingSource: BreedPagingSource
) : BreedRepository<Flow<PagingData<Breed>>> {

    override suspend fun getBreeds(): Flow<PagingData<Breed>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { breedPagingSource }
        ).flow
    }
}
