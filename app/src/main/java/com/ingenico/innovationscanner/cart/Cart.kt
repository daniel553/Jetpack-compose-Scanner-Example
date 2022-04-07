package com.ingenico.innovationscanner.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ingenico.innovationscanner.shared.CustomTopBar

@Composable
fun Cart(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        CartPage(navController)
    }
}

@Composable
fun CartPage(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(navController, "Cart", false)
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CART here!",
                    fontSize = 30.sp,
                    //color = Color.Black
                )
            }

        })
}