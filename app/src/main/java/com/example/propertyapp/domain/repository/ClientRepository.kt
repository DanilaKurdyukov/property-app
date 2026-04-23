package com.example.propertyapp.domain.repository

import com.example.propertyapp.domain.model.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun get(): Flow<Result<List<Client>>>
}