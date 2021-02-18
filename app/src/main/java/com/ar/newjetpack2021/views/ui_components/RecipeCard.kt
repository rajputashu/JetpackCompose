package com.ar.newjetpack2021.views.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ar.newjetpack2021.R
import com.ar.newjetpack2021.models.dto.RecipeResultDto
import com.ar.newjetpack2021.utils.loadImages

@Composable
fun RecipeCard(recipeMo: RecipeResultDto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column {

            recipeMo.featured_image?.let { url ->

                val imageBitmap = loadImages(url, R.drawable.empty_plate).value
                imageBitmap?.let {
                    Image(
                        bitmap = imageBitmap!!.asImageBitmap(), "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                recipeMo.title?.let { title ->
                    Row(modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                    ) {

                        Text(text = title,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(align = Alignment.Start),
                            style = MaterialTheme.typography.h5
                        )
                        Text(
                            text = recipeMo.rating.toString(),
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
                                .wrapContentWidth(align = Alignment.End)
                        )
                    }
                }
            }
        }
    }
}