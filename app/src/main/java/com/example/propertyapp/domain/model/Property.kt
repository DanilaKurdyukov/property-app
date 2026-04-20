package com.example.propertyapp.domain.model

data class Property(
    val id: Int,
    val street: String,
    val city: String,
    val number: String,
    val district: String,
    val area: Int,
    val roomsCount: Int,
    val floor: Int,
    val description: String,
    val price: Double,
    val typeId: Int,
    val statusId: Int,
    val status: String,
    val type: String,
    val photoUrl: String
)
