package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.MainScreen
import com.immortalidiot.wishescompose.presentation.viewmodels.GeneratorViewModel
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart

@Composable
fun EmojiGeneratorScreen(
    screenViewModel: GeneratorViewModel,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by screenViewModel.mutableStateFlow.collectAsState()
    val uiState by screenViewModel.uiState.collectAsState()

    PrimaryGeneratorScreen(
        modifier = modifier,
        headerText = stringResource(R.string.emoji_generator),
        inputValue = uiState.emojis,
        inputValueChange = { changedEmojis ->
            screenViewModel.changeNumberEmojis(changedEmojis)
        },
        onGenerateClick = {
            screenViewModel.generateEmojisAndCopy(uiState.emojis.toInt())
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
fun EmojiGeneratorScreenPreview() {
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
        EmojiGeneratorScreen(
            screenViewModel = hiltViewModel(),
            navHostController = rememberNavController()
        )
    }
}
