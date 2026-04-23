package com.example.propertyapp.data.network

import com.example.propertyapp.data.network.dto.ClientDTO
import com.example.propertyapp.data.network.dto.PropertyDTO
import retrofit2.http.GET

interface ApiService {
    @GET(value = "properties")
    suspend fun getProperties() : List<PropertyDTO>

    @GET(value = "clients")
    suspend fun getClients() : List<ClientDTO>
}