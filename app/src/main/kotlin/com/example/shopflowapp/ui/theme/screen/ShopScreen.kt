package com.example.shopflowapp.ui.theme.screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopflowapp.data.model.Product
import com.example.shopflowapp.ui.theme.component.CategoryRow
import com.example.shopflowapp.ui.theme.component.ProductCard
import com.example.shopflowapp.ui.theme.component.ProductListItem
import com.example.shopflowapp.ui.theme.component.PromoCard
import com.example.shopflowapp.ui.theme.component.ShopTopBar
import com.example.shopflowapp.viewmodel.ShopViewModel

@OptIn(ExperimentalFoundationApi::class)

@Composable
fun ShopScreen(viewModel: ShopViewModel = viewModel()) {
    val products = viewModel.products.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            ShopTopBar(onBackClick = {
                // Handle back navigation if needed
            })

            Column(modifier = Modifier.padding(16.dp)) {
                PromoCard()
                Spacer(modifier = Modifier.height(16.dp))
                CategoryRow()
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("New products", style = MaterialTheme.typography.titleLarge)
                    Text("See all", style = MaterialTheme.typography.labelLarge)
                }

                Spacer(modifier = Modifier.height(12.dp))

                if (products.value.isEmpty()) {
                    Text("No products found.", modifier = Modifier.padding(26.dp))
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(26.dp)) {
                        items(products.value) { product ->
                            ProductListItem(product)
                        }
                    }
                }
            }
        }
    }
}







