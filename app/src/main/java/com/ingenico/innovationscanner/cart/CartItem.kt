package com.ingenico.innovationscanner.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ingenico.innovationscanner.R
import com.ingenico.innovationscanner.ui.theme.CartItemBackground

@Composable
fun CartItemView(item: CartItem) {
    Card(
        modifier = Modifier
            .padding(8.dp, 6.dp, 8.dp, 6.dp)
            .background(
                color = CartItemBackground,
                shape = RoundedCornerShape(10)
            ),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.product.img),
                contentDescription = "Product",
                modifier = Modifier
                    .height(64.dp)
            )
            Column( modifier = Modifier.weight(0.8f)) {
                Text(text = item.product.name, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text =  "$ %.2f".format(item.product.price))
            }
            Text(text = "x${item.qt}", modifier = Modifier.align(Alignment.CenterVertically))
            Row( modifier = Modifier.align(Alignment.CenterVertically)) {
                IconButton( onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Clear,
                        "Remove",
                        tint = Color.Gray)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Add,
                        "Add",
                        tint = Color.Gray)
                }
            }
        }
    }
}