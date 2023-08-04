package com.example.data.mapper

import android.location.Location
import com.example.data.api.LocationRequest
import com.example.domain.model.LocationParam


fun MapperToLocation(locationParam: LocationParam): LocationRequest {
    return LocationRequest(
        x = locationParam.x,
        y = locationParam.y
    )
}