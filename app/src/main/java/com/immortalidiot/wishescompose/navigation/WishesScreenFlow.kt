package com.immortalidiot.wishescompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.navigation.main.mainScreenFlow

@Composable
fun WishesScreenFLow(
    paddingValues: PaddingValues,
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = WishesScreen.MainScreenFlow.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        mainScreenFlow(
            navHostController = navHostController
        ) {
            // invisible nav bar
        }
    }
}

