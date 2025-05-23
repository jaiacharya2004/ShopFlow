package com.example.shopflowapp.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shopflowapp.R

@Composable
fun PromoCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        // Grey background image
        Image(
            painter = painterResource(id = R.drawable.shopflowcard1),
            contentDescription = "Promo Card Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(2.dp))
        )

        Column(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "GET 20% OFF",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "On all products this week",
                color = Color.LightGray,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFB8FF3B), // Your green accent color
                        shape = RoundedCornerShape(50) // Fully rounded corners
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Till 31 June",
                    color = Color.Black, // Same green accent color
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}