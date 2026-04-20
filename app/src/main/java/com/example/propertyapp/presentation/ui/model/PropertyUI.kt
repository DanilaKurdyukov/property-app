package com.example.propertyapp.presentation.ui.model

data class PropertyUI(
    val id: Int,
    val address: String,
    val district: String,
    val characteristics: String,
    val description: String,
    val price: Double,
    val status: String,
    val type: String,
    val photoUrl: String
)