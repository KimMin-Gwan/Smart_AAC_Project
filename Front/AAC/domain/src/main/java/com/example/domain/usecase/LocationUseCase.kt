package com.example.domain.usecase

import android.location.Location
import com.example.domain.repository.LocationRepository

interface GetLocationUseCase {
    suspend fun execute(): Result<Location?>
}


class GetLocationUseCaseImpl(
    private val locationRepository: LocationRepository
): GetLocationUseCase {
    override suspend fun execute() = locationRepository.getLocation()
}