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
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopflowapp.data.model.Product
import com.example.shopflowapp.ui.theme.component.CategoryRow
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
        color = Color(0xFF424242)
    ) {
        Column {
            ShopTopBar(onBackClick = {
            })

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp)
            ) {
                item {
                    PromoCard()
                }

                item {
                    CategoryRow()
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("New products",     style = MaterialTheme.typography.titleMedium.copy(
                            fontFamily = FontFamily.Serif, fontSize = 20.sp))
                        Text("See all",     style = MaterialTheme.typography.titleMedium.copy(
                            fontFamily = FontFamily.Serif,))
                    }
                }


                if (products.value.isEmpty()) {
                    item {
                        Text("No products found.", modifier = Modifier.padding(26.dp))
                    }
                } else {
                    itemsIndexed(products.value) { index, product ->
                        ProductListItem(product = product)
                    }
                }
            }

        }
    }
}




