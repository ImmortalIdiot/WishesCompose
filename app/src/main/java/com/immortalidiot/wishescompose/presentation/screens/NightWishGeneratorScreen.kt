package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.MainScreen
import com.immortalidiot.wishescompose.presentation.viewmodels.GeneratorViewModel
import com.immortalidiot.wishescompose.ui.components.CustomToast
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import com.immortalidiot.wishescompose.ui.theme.defaultHeaderTextStyle
import com.immortalidiot.wishescompose.ui.theme.wishInHeaderTextStyle
import kotlinx.coroutines.delay

@Composable
fun NightWishGeneratorScreen(
    screenViewModel: GeneratorViewModel,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by screenViewModel.mutableStateFlow.collectAsState()
    val uiState by screenViewModel.uiState.collectAsState()

    val context = LocalContext.current

    val delayAfterClicking: Long = 2000

    val toastText = when (state) {
        is GeneratorViewModel.State.Success -> stringResource(R.string.wish_copied_hint)
        is GeneratorViewModel.State.Error -> (state as GeneratorViewModel.State.Error).message
        else -> null
    }

    val headerText = when (val currentState = state) {
        is GeneratorViewModel.State.Success -> currentState.wish!!
        else -> stringResource(R.string.number_of_emojis)
    }

    val headerTextStyle = if (state is GeneratorViewModel.State.Success) {
        wishInHeaderTextStyle
    } else {
        defaultHeaderTextStyle
    }

    toastText?.let { message ->
        CustomToast(context = context, toastText = message)

        LaunchedEffect(Unit) {
            delay(delayAfterClicking)
            screenViewModel.resetState()
        }
    }

    PrimaryGeneratorScreen(
        modifier = modifier,
        mainHeaderText = stringResource(R.string.night_wish_generator_mode),
        headerText = headerText,
        headerTextStyle = headerTextStyle,
        inputValue = uiState.emojis,
        inputValueChange = { changedEmojis ->
            screenViewModel.changeNumberEmojis(emojis = changedEmojis)
        },
        onGenerateClick = {
            screenViewModel.generateNightWishAndCopy(uiState.emojis)
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
        NightWishGeneratorScreen(
            screenViewModel = hiltViewModel(),
            navHostController = rememberNavController()
        )
    }
}
