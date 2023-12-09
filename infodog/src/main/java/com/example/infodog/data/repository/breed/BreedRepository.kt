package com.example.infodog.data.repository.breed

interface BreedRepository<out T> {
    suspend fun getBreeds(): T
}
