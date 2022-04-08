package com.ingenico.innovationscanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ingenico.innovationscanner.Router.Login
import com.ingenico.innovationscanner.cart.CartPage
import com.ingenico.innovationscanner.singon.LoginPage

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.Login.route) {

        composable(Router.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Router.Cart.route) {
            CartPage(navController = navController)
        }
    }
}