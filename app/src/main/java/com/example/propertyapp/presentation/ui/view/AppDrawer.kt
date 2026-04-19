package com.example.propertyapp.presentation.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.propertyapp.presentation.ui.model.DrawerItemModel


@Composable
fun AppDrawer(
    modifier: Modifier,
    selectedItem: String,
    onItemClick: (String) -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.width(250.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 15.dp, start = 15.dp),
            text = "Меню",
            style = MaterialTheme.typography.titleLarge
        )
        DrawerItemModel.screens.forEach { item ->
            DrawerItem(
                title = item.title,
                selected = selectedItem == item.route,
                icon = item.icon,
                onClick = {
                    onItemClick(item.route)
                }
            )
        }
    }
}

@Composable
fun DrawerItem(
    title: String,
    selected: Boolean,
    icon: ImageVector,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        label = { Text(title) },
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.Transparent,
            unselectedContainerColor = Color.Transparent,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface,
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onSurface,

        )
    )
}