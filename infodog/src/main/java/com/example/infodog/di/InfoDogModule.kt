package com.example.infodog.di

import androidx.paging.PagingData
import com.example.infodog.data.model.Breed
import com.example.infodog.data.repository.breed.BreedRemoteRepository
import com.example.infodog.data.repository.breed.BreedRepository
import com.example.infodog.data.source.remote.RetrofitClientFactory
import com.example.infodog.data.source.remote.paging.BreedPagingSource
import com.example.infodog.router.InfoDogRouter
import com.example.infodog.router.InfoDogRouterImpl
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module

val infoDogModule = module {
    single<InfoDogRouter> { InfoDogRouterImpl() }
    single { RetrofitClientFactory() }
    single { BreedPagingSource(get()) }
    single<BreedRepository<Flow<PagingData<Breed>>>> { BreedRemoteRepository(get()) }
}
