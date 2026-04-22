package com.example.propertyapp.presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.propertyapp.R


@Composable
fun FilterRow() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(size = 25.dp)
            )
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = {}
        ) {
            Text(
                text = "Все"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_mobiledata_arrows_24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = {}
        ) {
            Text(
                text = "Статус"
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            onClick = {}
        ) {
            Text(
                text = "Тип объекта"
            )
        }

    }
}