package com.example.data.repository

import android.location.Location
import com.example.data.mapper.MapperToCategory
import com.example.data.mapper.MapperToLocation
import com.example.data.model.remote.CategoryResponse
import com.example.data.source.remote.LocationDataSource
import com.example.domain.model.Categories
import com.example.domain.model.LocationParam
import com.example.domain.repository.LocationRepository
import javax.inject.Inject


class LocationRepositoryImpl @Inject constructor(private val locationDataSource: LocationDataSource
): LocationRepository {
    override suspend fun getLocation() = locationDataSource.getLocation()
    override suspend fun getCategories(param: LocationParam): Categories {
        val response = locationDataSource.getCategories(param)
        val result = mapToDomainModel(response)

        return result
    }

    private fun mapToDomainModel(response: CategoryResponse): Categories {
        val result = MapperToCategory(response)
        return result // 이곳에 실제 변환 로직을 구현해야 합니다.
    }
}