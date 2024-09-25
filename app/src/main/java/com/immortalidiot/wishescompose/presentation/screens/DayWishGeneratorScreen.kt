package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.MainScreen
import com.immortalidiot.wishescompose.presentation.viewmodels.GeneratorViewModel
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen

@Composable
fun DayWishGeneratorScreen(
    screenViewModel: GeneratorViewModel,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val uiState by screenViewModel.uiState.collectAsState()

    PrimaryGeneratorScreen(
        modifier = modifier,
        headerText = stringResource(R.string.day_wish_generator),
        inputValue = uiState.emojis,
        inputValueChange = { changedEmojis ->
            screenViewModel.changeNumberEmojis(changedEmojis)
        },
        onGenerateClick = {
            screenViewModel.generateDayWishAndCopy(uiState.emojis.toInt())
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
    DayWishGeneratorScreen(
        screenViewModel = hiltViewModel(),
        navHostController = rememberNavController()
    )
}
