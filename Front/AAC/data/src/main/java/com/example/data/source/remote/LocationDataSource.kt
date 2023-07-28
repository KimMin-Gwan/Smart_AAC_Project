package com.example.data.source.remote

import android.location.Location

interface LocationDataSource {
    suspend fun getLocation(): Result<Location?>
}