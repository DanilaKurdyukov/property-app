package com.example.propertyapp.presentation.ui.view

import android.graphics.Color
import androidx.compose.foundation.background
import com.example.propertyapp.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.example.propertyapp.presentation.ui.model.PropertyUI

@Composable
fun PropertyCardItem(property: PropertyUI) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (txtPrice, txtAddress, txtDistrict, txtCharacteristics, txtDescription, imgPropertyImage) = createRefs()

            AsyncImage(
                modifier = Modifier.constrainAs(imgPropertyImage) {
                    top.linkTo(anchor = parent.top)

                    end.linkTo(anchor = parent.end)
                }.fillMaxWidth().height(100.dp).padding(all = 0.dp),
                model = property.photoUrl,
                contentDescription = "News image",
                contentScale = ContentScale.Crop

            )

            Text(
                modifier = Modifier.constrainAs(ref = txtPrice) {
                    bottom.linkTo(anchor = imgPropertyImage.bottom)
                    start.linkTo(anchor = imgPropertyImage.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = property.price.toString()
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtAddress) {
                    top.linkTo(anchor = imgPropertyImage.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = property.address
            )

            Text (
                modifier = Modifier.constrainAs(ref = txtDistrict) {
                    top.linkTo(anchor = txtAddress.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = property.district
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtCharacteristics) {
                    top.linkTo(anchor = txtDistrict.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = property.characteristics
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtDescription) {
                    top.linkTo(anchor = txtCharacteristics.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = property.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}