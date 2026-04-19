package com.example.propertyapp.presentation.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerItemModel(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    data object Property : DrawerItemModel(title = "Объекты", route = "property", icon = Icons.Default.Home)
    data object Clients : DrawerItemModel(title = "Клиенты", route = "clients", icon = Icons.Default.Person)

    companion object {
        val screens: List<DrawerItemModel>
            get() = listOf(Property, Clients)
    }
}
