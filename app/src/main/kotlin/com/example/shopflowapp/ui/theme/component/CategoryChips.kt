package com.example.shopflowapp.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopflowapp.R

data class Category(
    val name: String,
    val imageResId: Int
)

@Composable
fun CategoryRow() {
    Text("Categories",     style = MaterialTheme.typography.titleMedium.copy(
        fontFamily = FontFamily.Serif, fontSize = 20.sp))
    val categories = listOf(
        Category("Cleanser", R.drawable.categorysample),
        Category("Toner", R.drawable.product_image),
        Category("Serum", R.drawable.categorysample),
        Category("Moisturizer", R.drawable.product_image),
        Category("Moisturizer", R.drawable.product_image),
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(categories) { category ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(4.dp)
            ) {
                // Circular product image
                Image(
                    painter = painterResource(id = category.imageResId),
                    contentDescription = "${category.name} category",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray.copy(alpha = 0.2f))
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category name - changed to White
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,  // Changed from DarkGray to White
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}