package com.example.data.repository

import com.example.data.mapper.MapperToCategory
import com.example.data.source.remote.LocationDataSource
import com.example.domain.model.Categories
import com.example.domain.repository.LocationRepository
import javax.inject.Inject


class LocationRepositoryImpl @Inject constructor(private val locationDataSource: LocationDataSource
): LocationRepository {
    override suspend fun getLocation() = locationDataSource.getLocation()
    override suspend fun getCategories(x: Double, y: Double): List<Categories> {
        val response = locationDataSource.getCategories(x,y)
        val result = MapperToCategory(response)
        return result
    }
}