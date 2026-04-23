package com.example.propertyapp.presentation.ui.view.client

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.propertyapp.presentation.ui.model.ClientUI
import com.example.propertyapp.presentation.ui.model.PropertyUI
import com.example.propertyapp.presentation.ui.view.property.PropertyCardItem
import com.example.propertyapp.presentation.vm.ClientViewModel

@Composable
fun ClientScreen() {
    val clientViewModel = hiltViewModel<ClientViewModel>()
    val clients by clientViewModel.clients.collectAsStateWithLifecycle()

    LaunchedEffect(clientViewModel) {
        clientViewModel.getClients()
    }
    ClientList(
        modifier = Modifier.fillMaxSize(),
        clients = clients
    )
}

@Composable
fun ClientList(
    modifier: Modifier,
    clients: List<ClientUI>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(clients) { client ->
            ClientCardItem(client)
        }
    }
}