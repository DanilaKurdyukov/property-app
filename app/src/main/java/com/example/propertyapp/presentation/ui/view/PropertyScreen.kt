package com.example.propertyapp.presentation.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.propertyapp.presentation.ui.model.PropertyUI
import com.example.propertyapp.presentation.ui.view.filter.status.FilterRow
import com.example.propertyapp.presentation.vm.PropertyViewModel

@Composable
fun PropertyScreen(
    modifier: Modifier
) {
    val propertyViewModel = hiltViewModel<PropertyViewModel>()

    val rentChecked by propertyViewModel.rentChecked.collectAsStateWithLifecycle()
    val availableChecked by propertyViewModel.availableChecked.collectAsStateWithLifecycle()
    val unavailableChecked by propertyViewModel.unavailableChecked.collectAsStateWithLifecycle()

    val properties by propertyViewModel.filteredProperties.collectAsStateWithLifecycle()

    LaunchedEffect(propertyViewModel) {
        propertyViewModel.getProperties()
    }

    Column(modifier = modifier) {
        FilterRow(
            rentChecked = rentChecked,
            availableChecked = availableChecked,
            unavailableChecked = unavailableChecked,
            onRentCheckedChange = propertyViewModel::setRentChecked,
            onAvailableCheckedChange = propertyViewModel::setAvailableChecked,
            onUnavailableCheckedChange = propertyViewModel::setUnavailableChecked
        )

        PropertyList(
            modifier = Modifier.fillMaxSize(),
            properties = properties
        )
    }
}

@Composable
fun PropertyList(
    modifier: Modifier,
    properties: List<PropertyUI>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(properties) { property ->
            PropertyCardItem(property)
        }
    }
}