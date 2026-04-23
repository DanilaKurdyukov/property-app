package com.example.propertyapp.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.propertyapp.domain.mapper.toUI
import com.example.propertyapp.domain.repository.PropertyRepository
import com.example.propertyapp.presentation.ui.model.PropertyUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val repository: PropertyRepository
): ViewModel() {

    private val _allProperties = MutableStateFlow(emptyList<PropertyUI>())
    val properties = _allProperties.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    private val _rentChecked = MutableStateFlow(false)
    val rentChecked = _rentChecked.asStateFlow()

    private val _availableChecked = MutableStateFlow(false)
    val availableChecked = _availableChecked.asStateFlow()

    private val _unavailableChecked = MutableStateFlow(false)
    val unavailableChecked = _unavailableChecked.asStateFlow()

    private val _selectedTypes = MutableStateFlow<Set<String>>(emptySet())
    val selectedTypes = _selectedTypes.asStateFlow()

    private val _selectedRooms = MutableStateFlow<Set<Int>>(emptySet())
    val selectedRooms = _selectedRooms.asStateFlow()

    private val _minPrice = MutableStateFlow<Double?>(null)
    val minPrice = _minPrice.asStateFlow()

    private val _maxPrice = MutableStateFlow<Double?>(null)
    val maxPrice = _maxPrice.asStateFlow()

    val filteredProperties = combine(
        _allProperties,
        _rentChecked,
        _availableChecked,
        _unavailableChecked,
        _selectedTypes,
        _selectedRooms,
        _minPrice,
        _maxPrice
    ) { values ->
        val properties = values[0] as List<PropertyUI>
        val rentChecked = values[1] as Boolean
        val availableChecked = values[2] as Boolean
        val unavailableChecked = values[3] as Boolean
        val selectedTypes = values[4] as Set<String>
        val selectedRooms = values[5] as Set<Int>
        val minPrice = values[6] as Double?
        val maxPrice = values[7] as Double?

        properties.filter { property ->

            val statusFilterPassed =
                if (!rentChecked && !availableChecked && !unavailableChecked) {
                    true
                } else {
                    (rentChecked && property.status == "В аренде") ||
                            (availableChecked && property.status == "Сдается") ||
                            (unavailableChecked && property.status == "Временно недоступно")
                }

            val typeFilterPassed =
                if (selectedTypes.isEmpty()) true
                else property.type in selectedTypes

            val roomsFilterPassed =
                if (selectedRooms.isEmpty()) true
                else property.roomsCount in selectedRooms

            val minPricePassed =
                minPrice?.let { property.price >= it } ?: true

            val maxPricePassed =
                maxPrice?.let { property.price <= it } ?: true

            statusFilterPassed &&
                    typeFilterPassed &&
                    roomsFilterPassed &&
                    minPricePassed &&
                    maxPricePassed
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    fun getProperties() {
        viewModelScope.launch {
            repository.get().collectLatest { result ->
                result
                    .onSuccess { data ->
                        _allProperties.value = data.map { it.toUI() }
                    }
                    .onFailure { e ->
                        _error.emit(e.message ?: "Unknown error")
                    }
            }
        }
    }

    fun setRentChecked(value: Boolean) {
        _rentChecked.value = value
    }

    fun setAvailableChecked(value: Boolean) {
        _availableChecked.value = value
    }

    fun setUnavailableChecked(value: Boolean) {
        _unavailableChecked.value = value
    }

    fun toggleType(type: String) {
        _selectedTypes.value =
            if (type in _selectedTypes.value) {
                _selectedTypes.value - type
            } else {
                _selectedTypes.value + type
            }
    }

    fun toggleRooms(rooms: Int) {
        _selectedRooms.value =
            if (rooms in _selectedRooms.value) {
                _selectedRooms.value - rooms
            } else {
                _selectedRooms.value + rooms
            }
    }

    fun setMinPrice(value: Double?) {
        _minPrice.value = value
    }

    fun setMaxPrice(value: Double?) {
        _maxPrice.value = value
    }

    fun clearFilters() {
        _rentChecked.value = false
        _availableChecked.value = false
        _unavailableChecked.value = false
        _selectedTypes.value = emptySet()
        _selectedRooms.value = emptySet()
        _minPrice.value = null
        _maxPrice.value = null
    }

}