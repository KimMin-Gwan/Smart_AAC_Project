package com.example.domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getLocation(): Result<Location?>
}