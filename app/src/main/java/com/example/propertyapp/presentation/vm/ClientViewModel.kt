package com.example.propertyapp.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.propertyapp.domain.mapper.toUI
import com.example.propertyapp.domain.repository.ClientRepository
import com.example.propertyapp.presentation.ui.model.ClientUI
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
class ClientViewModel @Inject constructor(
    private val repository: ClientRepository
): ViewModel() {

    private val _allClients = MutableStateFlow(emptyList<ClientUI>())
    val clients = _allClients.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    fun getClients() {
        viewModelScope.launch {
            repository.get().collectLatest { result ->
                result
                    .onSuccess { data ->
                        _allClients.value = data.map { it.toUI() }
                    }
                    .onFailure { e ->
                        _error.emit(e.message ?: "Unknown error")
                    }
            }
        }
    }

}