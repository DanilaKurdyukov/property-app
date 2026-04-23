package com.example.propertyapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class ClientDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("middleName")
    val middleName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("passportDataId")
    val passportDataId: Int,
    @SerializedName("passportSeries")
    val passportSeries: String,
    @SerializedName("passportNumber")
    val passportNumber: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("budgetMin")
    val budgetMin: Double,
    @SerializedName("budgetMax")
    val budgetMax: Double,
    @SerializedName("interest")
    val interest: Int,
    @SerializedName("interestName")
    val interestName: String,
    @SerializedName("photoUrl")
    val photoUrl: String
)
