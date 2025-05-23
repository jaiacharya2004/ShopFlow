package com.example.shopflowapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopflowapp.ui.theme.screen.SplashScreen
import com.example.shopflowapp.ui.theme.screen.ShopScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("shop") {
            ShopScreen()
        }
    }
}
