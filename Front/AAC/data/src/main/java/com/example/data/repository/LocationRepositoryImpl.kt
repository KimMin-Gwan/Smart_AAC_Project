package com.example.data.repository

import com.example.data.source.remote.LocationDataSource
import com.example.domain.repository.LocationRepository
import javax.inject.Inject


class LocationRepositoryImpl @Inject constructor(private val locationDataSource: LocationDataSource
): LocationRepository {
    override suspend fun getLocation() = locationDataSource.getLocation()
}