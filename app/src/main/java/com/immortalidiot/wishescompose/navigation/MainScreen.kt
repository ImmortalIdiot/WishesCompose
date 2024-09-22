package com.immortalidiot.wishescompose.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class MainScreen(val route: String) {
    data object ModeSelectionScreen: MainScreen("ModeSelection")
    data object EmojiGeneratorScreen: MainScreen("EmojiGenerator")
    data object DayWishGeneratorScreen: MainScreen("DayWishGenerator")
    data object NightWishGeneratorScreen: MainScreen("NightWishGenerator")
    data object DevelopersScreen: MainScreen("Developers")
}
