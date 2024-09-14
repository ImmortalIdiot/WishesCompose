package com.immortalidiot.wishescompose.navigation.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.immortalidiot.wishescompose.screens.ModeSelectionScreen

@Composable
fun MainScreenFlow(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.ModeSelectionScreen.route
    ) {
        composable(
            route = MainScreen.ModeSelectionScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            ModeSelectionScreen(navHostController = navHostController)
        }

        composable(
            route = MainScreen.EmojiGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the emoji generator screen
        }

        composable(
            route = MainScreen.DayWishGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the day wish generator screen
        }

        composable(
            route = MainScreen.NightWishGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the night wish generator screen
        }

        composable(
            route = MainScreen.DevelopersScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the developers screen
        }
    }
}
