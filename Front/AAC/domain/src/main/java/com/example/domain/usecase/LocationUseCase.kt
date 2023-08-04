package com.example.domain.usecase

import android.location.Location
import com.example.domain.model.Categories
import com.example.domain.model.LocationParam
import com.example.domain.repository.LocationRepository
import javax.inject.Inject


class LocationUseCase @Inject constructor(private val locationRepository: LocationRepository) {
     suspend fun execute() :Result<Location?> {
         return locationRepository.getLocation()
     }

    suspend fun getCategories(param : LocationParam) : Categories{
        return locationRepository.getCategories(param)
    }
}