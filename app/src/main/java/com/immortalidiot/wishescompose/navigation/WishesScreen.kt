package com.immortalidiot.wishescompose.navigation

import androidx.compose.runtime.Immutable
import com.immortalidiot.wishescompose.navigation.main.MainScreen

@Deprecated(
    message = "Unnecessary class",
    replaceWith = ReplaceWith("Replace with the MainScreen class")
)
@Immutable
sealed class WishesScreen(val route: String) {
    data object MainScreenFlow: WishesScreen("Main")
}
