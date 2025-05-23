package com.example.shopflowapp.ui.theme.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.shopflowapp.R

@Composable
fun SplashScreen(navController: NavController) {
    // Delay 2 seconds and navigate to shop screen
    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate("shop") {
            popUpTo("splash") { inclusive = true } // Remove splash from backstack
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cart3), // Your splash logo image here
            contentDescription = "App Logo",
            modifier = Modifier.size(180.dp)
        )
    }
}
