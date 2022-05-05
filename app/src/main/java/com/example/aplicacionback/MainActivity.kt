package com.example.aplicacionback

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacionback.Model.Producto
import com.example.aplicacionback.ui.theme.AplicacionBackTheme
import com.example.aplicacionback.view.ProductoItem
import com.example.aplicacionback.viewModel.ProductoViewModel

class MainActivity : ComponentActivity() {
    val productoViewModel by viewModels<ProductoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionBackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProductList(productList = productoViewModel.productlistResponse)
                    productoViewModel.getproductlist()
                }
            }
        }
    }
}

@Composable
fun ProductList (productList: List<Producto>) {
    LazyColumn {
        itemsIndexed(items = productList) { index, item ->
            ProductoItem(producto = item)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AplicacionBackTheme {
        Greeting("Android")
    }
}


