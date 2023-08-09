package com.example.data.mapper

import com.example.data.model.remote.LocationRequest
import com.example.domain.model.LocationParam


fun MapperToLocation(locationParam: LocationParam): LocationRequest {
    return LocationRequest(
        x = locationParam.x,
        y = locationParam.y
    )
}