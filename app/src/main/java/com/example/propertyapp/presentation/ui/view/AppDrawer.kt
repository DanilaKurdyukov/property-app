package com.example.propertyapp.presentation.ui.view

import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.propertyapp.presentation.ui.model.DrawerItemModel

val items = listOf(
    DrawerItemModel("Главная", "home"),
    DrawerItemModel("Объекты", "properties")
)

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
            text = "Меню",
            style = MaterialTheme.typography.titleLarge
        )
        items.forEach { item ->
            DrawerItem(
                title = item.title,
                selected = selectedItem == item.route,
                onClick = {
                    onItemClick(item.route)
                }
            )
        }
        DrawerItem(
            title = "Главная",
            selected = selectedItem == "home",
            onClick = {
                onItemClick("home")
            }
        )
    }
}

@Composable
fun DrawerItem(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        label = { Text(title) },
        selected = selected,
        onClick = onClick,
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.Transparent,
            unselectedContainerColor = Color.Transparent,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface,
            selectedIconColor = MaterialTheme.colorScheme.onSurface,
            unselectedIconColor = MaterialTheme.colorScheme.onSurface
        )
    )
}