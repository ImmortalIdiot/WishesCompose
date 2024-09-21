package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.main.MainScreen
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen

@Composable
fun DayWishGeneratorScreen(
    // TODO: add view model
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    PrimaryGeneratorScreen(
        modifier = modifier,
        headerText = stringResource(R.string.day_wish_generator),
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
        },
    )
}

@Preview
@Composable
fun DayWishGeneratorScreenPreview() {
    DayWishGeneratorScreen(navHostController = rememberNavController())
}
