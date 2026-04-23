package com.example.propertyapp.data.mapper

import com.example.propertyapp.data.network.dto.ClientDTO
import com.example.propertyapp.data.network.dto.PropertyDTO
import com.example.propertyapp.domain.model.Client
import com.example.propertyapp.domain.model.Property

fun PropertyDTO.toDomain(): Property =
    Property(
        id = id,
        street = street,
        city = city,
        number = number,
        district = district,
        area = area,
        roomsCount = roomsCount,
        floor = floor,
        description = description,
        price = price,
        typeId = typeId,
        statusId = statusId,
        status = status,
        type = type,
        photoUrl = photoUrl
    )
fun ClientDTO.toDomain(): Client =
    Client(
        id = id,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        phone = phone,
        email = email,
        passportDataId = passportDataId,
        passportSeries = passportSeries,
        passportNumber = passportNumber,
        address = address,
        budgetMin = budgetMin,
        budgetMax = budgetMax,
        interest = interest,
        interestName = interestName,
        photoUrl = photoUrl
    )
