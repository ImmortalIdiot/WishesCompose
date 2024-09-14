package com.immortalidiot.wishescompose.navigation.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreenFlow(
    navHostController: NavHostController = rememberNavController(),
    screenName: (String) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.ModeSelectionScreen.route,
        route = MainScreen.ModeSelectionScreen.route
    ) {
        composable(
            route = MainScreen.ModeSelectionScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the mode selection screen
            screenName("Mode selection")
        }

        composable(
            route = MainScreen.EmojiGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the emoji generator screen
            screenName("Emoji generator")
        }

        composable(
            route = MainScreen.DayWishGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the day wish generator screen
            screenName("Day wish generator")
        }

        composable(
            route = MainScreen.NightWishGeneratorScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the night wish generator screen
            screenName("Night wish generator")
        }

        composable(
            route = MainScreen.DevelopersScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO: add the developers screen
            screenName("Developers")
        }
    }
}
