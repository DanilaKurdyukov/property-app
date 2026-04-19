package com.example.propertyapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.propertyapp.presentation.ui.model.DrawerItemModel
import com.example.propertyapp.presentation.ui.view.ClientScreen
import com.example.propertyapp.presentation.ui.view.DealScreen
import com.example.propertyapp.presentation.ui.view.PropertyScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DrawerItemModel.Property.route,
        modifier = modifier
    ) {
        composable(DrawerItemModel.Property.route) {
            PropertyScreen()
        }
        composable(DrawerItemModel.Clients.route) {
            ClientScreen()
        }
        composable(DrawerItemModel.Deals.route) {
            DealScreen()
        }
    }
}