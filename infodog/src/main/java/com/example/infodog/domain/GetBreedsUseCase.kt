package com.example.infodog.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.example.infodog.data.model.Breed
import com.example.infodog.data.repository.breed.BreedRepository
import com.example.infodog.ui.model.BreedUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetBreedsUseCase(
    private val breedRepository: BreedRepository<Flow<PagingData<Breed>>>
) {

    suspend operator fun invoke(): Flow<PagingData<BreedUI>> {
        return breedRepository.getBreeds().map { pagingData ->
            pagingData.map { breed ->
                convertToBreedUI(breed)
            }
        }
    }

    private fun convertToBreedUI(breed: Breed): BreedUI {
        return breed.run {
            BreedUI(
                id = id,
                name = name,
                imageId = image.id,
                imageUrl = image.url
            )
        }
    }
}
