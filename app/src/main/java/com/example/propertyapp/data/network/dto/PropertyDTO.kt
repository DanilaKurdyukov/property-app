package com.example.propertyapp.data.network.dto

import com.google.gson.annotations.SerializedName


data class PropertyDTO(
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "street")
    val street: String,
    @SerializedName(value = "city")
    val city: String,
    @SerializedName(value = "number")
    val number: String,
    @SerializedName(value = "district")
    val district: String,
    @SerializedName(value = "area")
    val area: Int,
    @SerializedName(value = "roomsCount")
    val roomsCount: Int,
    @SerializedName(value = "floor")
    val floor: Int,
    @SerializedName(value = "description")
    val description: String,
    @SerializedName(value = "price")
    val price: Double,
    @SerializedName(value = "type")
    val type: String,
    @SerializedName(value = "status")
    val status: String,
    @SerializedName(value = "typeId")
    val typeId: Int,
    @SerializedName(value = "statusId")
    val statusId: Int,
    @SerializedName(value = "photoUrl")
    val photoUrl: String
)
