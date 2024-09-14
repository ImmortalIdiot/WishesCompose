package com.immortalidiot.wishescompose.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class WishesScreen(val route: String) {
    data object MainScreenFlow: WishesScreen("Main")
}
