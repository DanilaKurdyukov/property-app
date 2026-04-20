package com.example.propertyapp.domain.mapper

import com.example.propertyapp.domain.model.Property
import com.example.propertyapp.presentation.ui.model.PropertyUI

fun Property.toUI(): PropertyUI =
    PropertyUI(
        id = id,
        address = "$city, $street $number",
        district = district,
        characteristics = "$area м² · $roomsCount · $floor",
        description = description,
        price = price
    )