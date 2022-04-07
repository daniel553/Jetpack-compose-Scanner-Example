package com.ingenico.innovationscanner.cart

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ingenico.innovationscanner.R
import com.ingenico.innovationscanner.Router
import com.ingenico.innovationscanner.shared.CustomTopBar

@Composable
fun Cart(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        CartPage(navController)
    }
}

@Composable
fun CartPage(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CustomTopBar(navController, "Cart", false)
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CartMainView()
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { launchScanner(context) }
            ) {
                Icon(Icons.Filled.ShoppingCart,"Add")
            }
        }
    )
}

@Composable
fun CartMainView() {
    if (CartDataSource.getItems().isNotEmpty()) {
        CartListView()
    } else {
        CartEmptyView()
    }
}

@Composable
fun CartEmptyView() {
    val context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.ic_empty_cart),
        contentDescription = "Ingenico",
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 36.dp)
    )
    Text(
        text = "Start adding products to your cart!",
        fontSize = 22.sp,
        //color = Color.Black
    )
    Spacer(modifier = Modifier.height(20.dp))
    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
        Button(
            onClick = { launchScanner(context) },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Scan now!")
        }
    }
}

@Composable
fun CartListView() {

}

fun launchScanner(context: Context) {
    Toast.makeText(context, "Launching Scanner", Toast.LENGTH_SHORT).show()
}