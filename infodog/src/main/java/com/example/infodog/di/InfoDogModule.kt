package com.example.infodog.di

import com.example.infodog.router.InfoDogRouter
import com.example.infodog.router.InfoDogRouterImpl
import org.koin.dsl.module

val infoDogModule = module {
    single<InfoDogRouter> { InfoDogRouterImpl() }
}
