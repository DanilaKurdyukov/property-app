package com.example.propertyapp.presentation.di

import com.example.propertyapp.data.network.ApiService
import com.example.propertyapp.data.repository.PropertyRepositoryImpl
import com.example.propertyapp.domain.repository.PropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun providePropertyRepository(apiService: ApiService): PropertyRepository =
        PropertyRepositoryImpl(apiService)
}