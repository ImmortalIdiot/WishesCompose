package com.immortalidiot.wishescompose.presentation.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.MainScreen
import com.immortalidiot.wishescompose.ui.components.PrimaryButton
import com.immortalidiot.wishescompose.ui.theme.Dimensions
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun ModeSelectionScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val dimensions = LocalDimensions.current
    val context = LocalContext.current

    BackHandler { (context as Activity).moveTaskToBack(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = dimensions.verticalBigPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.selection_mode),
            fontSize = modeHeaderText.fontSize,
            color = Color.White,
            fontStyle = modeHeaderText.fontStyle,
            fontFamily = modeHeaderText.fontFamily,
            fontWeight = FontWeight.Bold
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensions.verticalSmallPadding)
        ) {
            listOf(
                R.string.emoji_generator to MainScreen.EmojiGeneratorScreen.route,
                R.string.day_wish_generator to MainScreen.DayWishGeneratorScreen.route,
                R.string.night_wish_generator_mode to MainScreen.NightWishGeneratorScreen.route
            ).forEach { (resourceId, route) ->
                NavigateButton(
                    modifier = modifier,
                    resourceId = resourceId,
                    route = route,
                    navHostController = navHostController,
                    dimensions = dimensions
                )
            }
        }
        NavigateButton(
            resourceId = R.string.developers,
            route = MainScreen.DevelopersScreen.route,
            navHostController = navHostController,
            modifier = modifier,
            dimensions = dimensions,
            isSmall = true
        )
    }
}

@Composable
fun NavigateButton(
    resourceId: Int,
    route: String,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    dimensions: Dimensions = LocalDimensions.current,
    isSmall: Boolean = false
) {
    PrimaryButton(
        modifier = modifier,
        maxWidth = if (isSmall) {
            dimensions.smallWidthButton
        } else {
            dimensions.bigWidthButton
        },
        maxHeight = dimensions.heightButton,
        text = stringResource(resourceId),
        onClick = {
            navHostController.navigate(route) {
                popUpTo(route) { inclusive = false }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}
