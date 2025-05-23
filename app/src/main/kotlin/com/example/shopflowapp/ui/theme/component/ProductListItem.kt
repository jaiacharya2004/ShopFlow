package com.example.shopflowapp.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.res.painterResource
import com.example.shopflowapp.R
import com.example.shopflowapp.data.model.Product

@Composable
fun ProductListItem(
    product: Product,
    onAddToCart: () -> Unit = {},
    onFavoriteClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        // First card - for product image (larger card)
        Card(
            modifier = Modifier
                .height(460.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF424242)
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Background image for the first card
                Image(
                    painter = painterResource(id = R.drawable.card_grey_bg_png),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.matchParentSize()
                )

                // Favorites heart icon
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.TopStart)
                        .padding(6.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Black.copy(alpha = 0.9f),
                        contentColor = Color(0xFFBA68C8)
                    )
                ) {
                    Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                }

                // Product image centered in the first card
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(290.dp)
                        .align(Alignment.TopCenter)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
        }

        // Second card - for product details (overlay on bottom)
        Card(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .height(130.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-16).dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Background image for details card
                Image(
                    painter = painterResource(id = R.drawable.card_black_shape),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )

                // Content overlay with slight transparency
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Product Name
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        // Description
                        Text(
                            text = "Premium Quality • Comfort Fit",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.White.copy(alpha = 0.8f)
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Price information
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "₹${"%.2f".format(product.price)}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )

                            product.originalPrice?.let { originalPrice ->
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "₹${"%.2f".format(originalPrice)}",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        textDecoration = TextDecoration.LineThrough,
                                        color = Color.White.copy(alpha = 0.6f)
                                    )
                                )

                                if (originalPrice > product.price) {
                                    Spacer(modifier = Modifier.width(8.dp))
                                    val discountPercent = ((originalPrice - product.price) / originalPrice * 100).toInt()
                                    Text(
                                        text = "$discountPercent% OFF",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            color = Color(0xFFFFD700)
                                        ),
                                        modifier = Modifier
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                            .background(
                                                color = Color.White.copy(alpha = 0.2f),
                                                shape = RoundedCornerShape(4.dp)
                                            )
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        // Rating and Add to Cart button
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Rating
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Rating",
                                    tint = Color(0xFFFFD700),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "4.8",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        color = Color.White
                                    )
                                )
                                Text(
                                    text = " (126)",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = Color.White.copy(alpha = 0.7f)
                                    )
                                )
                            }

                            // Add to cart button (kept on second card)
                            FilledIconButton(
                                onClick = onAddToCart,
                                modifier = Modifier.size(36.dp),
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.primary
                                ),
                                shape = CircleShape
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cart3),
                                    contentDescription = "Add to cart",
                                    modifier = Modifier.size(60.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}