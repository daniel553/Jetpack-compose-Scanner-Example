package com.ingenico.innovationscanner

sealed class Router(val route: String) {
    object Login: Router("Login")
    object Cart: Router("Cart")
}