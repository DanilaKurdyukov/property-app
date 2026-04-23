package com.example.propertyapp.domain.mapper

import com.example.propertyapp.domain.model.Client
import com.example.propertyapp.domain.model.Property
import com.example.propertyapp.presentation.ui.model.ClientUI
import com.example.propertyapp.presentation.ui.model.PropertyUI

fun Property.toUI(): PropertyUI =
    PropertyUI(
        id = id,
        address = "$city, $street $number",
        district = district,
        characteristics = "$area м² · $roomsCount комн · $floor этаж",
        description = description,
        price = price,
        status = status,
        type = type,
        photoUrl = photoUrl,
        roomsCount = roomsCount
    )
fun Client.toUI(): ClientUI =
    ClientUI(
        fullName = "$firstName $middleName $lastName",
        phone = phone,
        email = email,
        passportSeries = passportSeries,
        passportNumber = passportNumber,
        address = address,
        budget = "$budgetMin - $budgetMax",
        interestName = interestName,
        photoUrl = photoUrl
    )