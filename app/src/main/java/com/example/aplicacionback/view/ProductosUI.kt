package com.example.aplicacionback.view

import android.graphics.Color
import android.icu.number.Scale
import android.util.Log
import android.view.Gravity.FILL
import android.widget.GridLayout.FILL
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.aplicacionback.Model.Producto

@Composable
fun ProductoItem(producto: Producto) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    )
    {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = producto.URL,
                        builder = {
                            scale(coil.size.Scale.FILL)
                            placeholder(coil.compose.base.R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = producto.name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = producto.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = producto.clave,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(LightGray)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

