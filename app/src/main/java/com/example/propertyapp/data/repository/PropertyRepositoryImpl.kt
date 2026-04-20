package com.example.propertyapp.data.repository

import com.example.propertyapp.data.mapper.toDomain
import com.example.propertyapp.data.network.ApiService
import com.example.propertyapp.domain.model.Property
import com.example.propertyapp.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PropertyRepository {
    override suspend fun get(): Flow<Result<List<Property>>> = flow{
        try{
            val data = apiService.getProperties()
            emit(Result.success(data.map { it.toDomain() }))
        }  catch (e: IOException) {
            emit(Result.failure(e))
        } catch (e: retrofit2.HttpException) {
            emit(Result.failure(e))
        }
    }
}