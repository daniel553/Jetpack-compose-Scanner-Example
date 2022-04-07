package com.ingenico.innovationscanner.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ingenico.innovationscanner.R

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
    LazyColumn {
        items(CartDataSource.getItems()) {
            CartItemView(it)
        }
    }
}