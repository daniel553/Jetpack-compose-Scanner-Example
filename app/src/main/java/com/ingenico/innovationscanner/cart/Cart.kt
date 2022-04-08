package com.ingenico.innovationscanner.cart

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.ingenico.innovationscanner.MainActivity
import com.ingenico.innovationscanner.shared.CustomTopBar
import com.ingenico.innovationscanner.utils.getActivity

@Composable
fun Cart(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        CartPage(navController)
    }
}

@Composable
fun CartPage(navController: NavHostController) {
    val context = LocalContext.current
    val cartItems = remember { mutableStateListOf<CartItem>() }
    CartDataSource.registerCartItems(cartItems)

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
                CartMainView(cartItems.toList())
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { launchScanner(context) }
            ) {
                Icon(Icons.Filled.AddCircle,"Add")
            }
        }
    )
}

@Composable
fun CartMainView(cartItems: List<CartItem>) {
    if (cartItems.isNotEmpty()) {
        CartListView(cartItems)
    } else {
        CartEmptyView()
    }
}


fun launchScanner(context: Context) {
    Toast.makeText(context, "Launching Scanner", Toast.LENGTH_SHORT).show()
    (context.getActivity() as MainActivity).scanBarcode()
}