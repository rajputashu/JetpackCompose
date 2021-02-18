package com.ar.newjetpack2021.views.ui_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChipsWidget(isSelected: Boolean = false,
                        category: String,
                        onChipSelected: (String) -> Unit) {
    Surface(modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 3.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary) {

        Row(modifier = Modifier.clickable(onClick = { onChipSelected(category) })) {
            Text(text = category,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}