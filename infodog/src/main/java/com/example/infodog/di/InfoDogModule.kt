package com.example.infodog.di

import com.example.infodog.data.repository.breed.BreedRemoteRepository
import com.example.infodog.data.source.remote.RetrofitClientFactory
import com.example.infodog.data.source.remote.paging.BreedPagingSource
import com.example.infodog.router.InfoDogRouter
import com.example.infodog.router.InfoDogRouterImpl
import org.koin.dsl.module

val infoDogModule = module {
    single<InfoDogRouter> { InfoDogRouterImpl() }
    single { RetrofitClientFactory() }
    single { BreedPagingSource(get()) }
    single { BreedRemoteRepository(get()) }
}
