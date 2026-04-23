package com.example.propertyapp.data.repository

import com.example.propertyapp.data.mapper.toDomain
import com.example.propertyapp.data.network.ApiService
import com.example.propertyapp.domain.model.Client
import com.example.propertyapp.domain.repository.ClientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class ClientRepositoryImpl  @Inject constructor(
    private val apiService: ApiService
): ClientRepository{
    override suspend fun get(): Flow<Result<List<Client>>> = flow{
        try {
            val data = apiService.getClients()
            emit(Result.success(data.map { it.toDomain() }))
        } catch (e: IOException){
            emit(Result.failure(e))
        } catch (e: retrofit2.HttpException) {
            emit(Result.failure(e))
        }

    }
}