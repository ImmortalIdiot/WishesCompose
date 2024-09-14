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
import com.immortalidiot.wishescompose.navigation.main.MainScreen
import com.immortalidiot.wishescompose.ui.components.PrimaryButton
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun ModeSelectionScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val dimension = LocalDimensions.current
    val context = LocalContext.current

    BackHandler {
        (context as Activity).moveTaskToBack(true)
    }

    Column(
        modifier = modifier.fillMaxSize().padding(vertical = dimension.verticalBigPadding),
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
            verticalArrangement = Arrangement.spacedBy(dimension.verticalSmallPadding)
        ) {
            PrimaryButton(
                modifier = modifier,
                maxWidth = dimension.bigWidthButton,
                maxHeight = dimension.heightButton,
                text = stringResource(R.string.emoji_generator),
                onClick = {
                    // TODO: move to emoji generator
                }
            )

            PrimaryButton(
                modifier = modifier,
                maxWidth = dimension.bigWidthButton,
                maxHeight = dimension.heightButton,
                text = stringResource(R.string.day_wish_generator),
                onClick = {
                    // TODO: move to day wish generator
                }
            )

            PrimaryButton(
                modifier = modifier,
                maxWidth = dimension.bigWidthButton,
                maxHeight = dimension.heightButton,
                text = stringResource(R.string.night_wish_generator_mode),
                onClick = {
                    // TODO: move to night wish generator
                }
            )
        }

        PrimaryButton(
            modifier = modifier,
            maxHeight = dimension.heightButton,
            maxWidth = dimension.smallWidthButton,
            text = stringResource(R.string.developers),
            onClick = {
                navHostController.navigate(MainScreen.DevelopersScreen.route) {
                    popUpTo(MainScreen.DevelopersScreen.route) {
                        inclusive = false
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
