package com.example.propertyapp.domain.model

data class Client(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val passportDataId: Int,
    val passportSeries: String,
    val passportNumber: String,
    val address: String,
    val budgetMin: Double,
    val budgetMax: Double,
    val interest: Int,
    val interestName: String,
    val photoUrl: String
)
