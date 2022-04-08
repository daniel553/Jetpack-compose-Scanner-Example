package com.ingenico.innovationscanner.cart

import CustomDialog
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ingenico.innovationscanner.R
import com.ingenico.innovationscanner.Router

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
fun CartListView(cartItems: List<CartItem>) {
    Log.d("Items", cartItems.toString())
    LazyColumn {
        items(cartItems) {
            CartItemView(it)
        }
    }
    TotalView()
}

@Composable
fun TotalView() {
    val openDialogCustom = remember{ mutableStateOf(false) }
    Row(
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .background(com.ingenico.innovationscanner.ui.theme.Purple500)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.ShoppingCart, "Shopping Cart", tint = Color.White)
        Text(
            text = "${CartDataSource.totalItems()} items | ",
            color = Color.White,
            modifier = Modifier.padding(start= 4.dp, end = 4.dp)
        )
        Text(
            text = "$"+"%.2f".format(CartDataSource.totalAmount()),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(0.8f)
                .padding(start = 4.dp, end = 4.dp)
        )
        Button(
            onClick = {openDialogCustom.value = true },
            shape = RoundedCornerShape(52.dp),
            modifier = Modifier
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(text = "Checkout", color = com.ingenico.innovationscanner.ui.theme.Purple500 )
        }
    }
    if (openDialogCustom.value) {
        CustomDialog(openDialogCustom = openDialogCustom)
    }
}