package com.example.propertyapp.presentation.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
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
import com.example.propertyapp.presentation.vm.PropertyViewModel

@Composable
fun PropertyScreen(
    modifier: Modifier
) {
    val propertyViewModel = hiltViewModel<PropertyViewModel>()
    PropertyList(
        modifier = modifier,
        propertyViewModel = propertyViewModel
    )
}

@Composable
fun PropertyList(
    modifier: Modifier,
    propertyViewModel: PropertyViewModel
) {
    val properties by propertyViewModel.properties.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = propertyViewModel) {
        propertyViewModel.getProperties()
    }
    LazyColumn(
        modifier = modifier
    ) {
        items(items = properties) {property ->
            PropertyCardItem(property)
        }
    }
}