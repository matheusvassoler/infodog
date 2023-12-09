package com.example.infodog.data.source.remote

interface RestClient {
    fun <T> createRetrofitService(baseUrl: String, service: Class<T>): T
}
