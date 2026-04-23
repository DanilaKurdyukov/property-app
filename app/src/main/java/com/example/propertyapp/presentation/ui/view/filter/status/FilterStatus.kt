package com.example.propertyapp.presentation.ui.view.filter.status

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterStatus(
    rentChecked: Boolean,
    availableChecked: Boolean,
    unavailableChecked: Boolean,
    onRentCheckedChange: (Boolean) -> Unit,
    onAvailableCheckedChange: (Boolean) -> Unit,
    onUnavailableCheckedChange: (Boolean) -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            FilterCheckItem(
                title = "Сдается",
                checked = availableChecked,
                onCheckedChange = onAvailableCheckedChange
            )
            FilterCheckItem(
                title = "В аренде",
                checked = rentChecked,
                onCheckedChange = onRentCheckedChange
            )
            FilterCheckItem(
                title = "Временно недоступно",
                checked = unavailableChecked,
                onCheckedChange = onUnavailableCheckedChange
            )
        }
    }
}
