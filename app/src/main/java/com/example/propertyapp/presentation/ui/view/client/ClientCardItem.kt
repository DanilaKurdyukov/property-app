package com.example.propertyapp.presentation.ui.view.client

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.example.propertyapp.presentation.ui.model.ClientUI

@Composable
fun ClientCardItem(client: ClientUI) {
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
            val (txtFullName, txtPhone, txtEmail, txtAddress, txtBudget, txtInterestName, imgClientImage, btnForward) = createRefs()

            AsyncImage(
                modifier = Modifier.constrainAs(imgClientImage) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                }.padding(all = 10.dp).size(100.dp)
                    .clip(CircleShape),
                model = client.photoUrl,
                contentDescription = "Client image",
                contentScale = ContentScale.Crop

            )

            Text(
                modifier = Modifier.constrainAs(ref = txtFullName) {
                    top.linkTo(anchor = imgClientImage.top)
                    bottom.linkTo(anchor = imgClientImage.bottom)
                    start.linkTo(anchor = imgClientImage.end)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = client.fullName
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtInterestName) {
                    top.linkTo(anchor = txtFullName.top)
                    bottom.linkTo(anchor = imgClientImage.bottom)
                    start.linkTo(anchor = imgClientImage.end)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = "Интересует: ${client.interestName}"
            )

            Text (
                modifier = Modifier.constrainAs(ref = txtPhone) {
                    top.linkTo(anchor = imgClientImage.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = client.phone
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtEmail) {
                    top.linkTo(anchor = txtPhone.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = client.email
            )

            Text(
                modifier = Modifier.constrainAs(ref = txtAddress) {
                    top.linkTo(anchor = txtEmail.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = client.address,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

           /* IconButton(
                modifier = Modifier.constrainAs(ref = btnForward) {
                    top.linkTo(anchor = imgPropertyImage.bottom)
                    end.linkTo(anchor = parent.end)
                },
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = null
                )
            }*/

            Text(
                modifier = Modifier.constrainAs(ref = txtBudget) {
                    top.linkTo(anchor = txtAddress.bottom)
                    start.linkTo(anchor = parent.start)
                }.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                text = "Бюджет: ${client.budget}"
            )

        }
    }
}