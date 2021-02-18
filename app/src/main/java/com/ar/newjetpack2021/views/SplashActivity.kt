package com.ar.newjetpack2021.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.ar.newjetpack2021.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContent {
            ScrollableColumn(
                modifier = Modifier
                    .background(color = Color(0xFFF2F2F2))
                    .fillMaxHeight(),
            ) {
                Image(
                    bitmap = imageFromResource(
                        res = resources,
                        resId = R.drawable.happy_meal
                    ),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier.padding(12.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Hot & Crispy Veg Meal",
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(20)
                            )
                        )

                        Text(
                            text = "$2.90", style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(15),
                                color = Color(0xFF85bb65)
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "Burger", style = TextStyle(fontSize = TextUnit.Companion.Sp(16)))
                    Spacer(modifier = Modifier.padding(top = 30.dp))
                    Button(
                        onClick = {
                            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Order Now")
                    }
                }
            }
        }
    }
}