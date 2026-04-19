package com.example.propertyapp.presentation.ui.model

import android.graphics.drawable.Drawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.propertyapp.R

sealed class DrawerItemModel(
    val title: String,
    val route: String,
    val icon: Int
) {
    data object Property : DrawerItemModel(title = "Объекты", route = "property", icon = R.drawable.outline_family_home_24)
    data object Clients : DrawerItemModel(title = "Клиенты", route = "clients", icon = R.drawable.outline_person_24)

    data object Deals : DrawerItemModel(title = "Сделки", route = "deals", icon = R.drawable.outline_attach_money_24)

    companion object {
        val screens: List<DrawerItemModel>
            get() = listOf(Property, Clients, Deals)
    }
}
