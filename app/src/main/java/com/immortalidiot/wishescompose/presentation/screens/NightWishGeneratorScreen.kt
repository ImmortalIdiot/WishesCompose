package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.main.MainScreen
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart

@Composable
fun NightWishGeneratorScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    PrimaryGeneratorScreen(
        modifier = modifier,
        headerText = stringResource(R.string.night_wish_generator_mode),
        inputValueChange = {
            // TODO: implement onValueChange
        },
        // TODO: implement value
        onGenerateClick = {
            // TODO: implement viewmodel.generate()
        },
        onBackButton = {
            navHostController.popBackStack(
                route = MainScreen.ModeSelectionScreen.route,
                inclusive = false,
                saveState = true
            )
        }
    )
}

@Preview
@Composable
fun NightWishGeneratorScreenPreview() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        BackgroundStart,
                        BackgroundEnd
                    )
                )
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NightWishGeneratorScreen(navHostController = rememberNavController())
    }
}
