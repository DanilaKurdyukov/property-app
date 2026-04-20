package com.example.propertyapp.domain.repository

import com.example.propertyapp.domain.model.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    suspend fun get(): Flow<Result<List<Property>>>
}