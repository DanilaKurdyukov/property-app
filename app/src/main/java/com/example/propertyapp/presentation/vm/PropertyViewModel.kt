package com.example.propertyapp.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.propertyapp.domain.mapper.toUI
import com.example.propertyapp.domain.repository.PropertyRepository
import com.example.propertyapp.presentation.ui.model.PropertyUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val repository: PropertyRepository
): ViewModel() {

    private val _properties = MutableStateFlow(value = emptyList<PropertyUI>())
    val properties = _properties.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    fun getProperties() {
        viewModelScope.launch {
            repository.get().collectLatest { result ->
                result
                    .onSuccess {
                    data -> _properties.value = data.map { it.toUI() }
                }
                    .onFailure { e ->
                        _error.emit(e.message ?: "Unknown error")
                    }
            }
        }
    }

}