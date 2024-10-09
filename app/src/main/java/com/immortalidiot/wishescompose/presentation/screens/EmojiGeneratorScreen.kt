package com.immortalidiot.wishescompose.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.immortalidiot.wishescompose.providers.LocalSnackbarHostState
import com.immortalidiot.wishescompose.providers.showMessage
import com.immortalidiot.wishescompose.ui.components.PrimaryGeneratorScreen
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import com.immortalidiot.wishescompose.ui.theme.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EmojiGeneratorScreen(
    screenViewModel: GeneratorViewModel,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by screenViewModel.mutableStateFlow.collectAsState()
    val uiState by screenViewModel.uiState.collectAsState()

    val context = LocalContext.current

    val snackbarHostState = LocalSnackbarHostState.current
    val snackbarDuration: Long = Constants.SNACKBAR_DURATION

    var isToastTriggered by remember { mutableStateOf(false) }
    var isToastShowing by remember { mutableStateOf(false) }

    fun goBackPressed() {
        screenViewModel.resetState()
        navHostController.popBackStack(
            route = MainScreen.ModeSelectionScreen.route,
            inclusive = false,
            saveState = true
        )
    }

    BackHandler { goBackPressed() }

    LaunchedEffect(isToastTriggered) {
        if (isToastTriggered && !isToastShowing &&
            (state is GeneratorViewModel.State.Success || state is GeneratorViewModel.State.Error)
        ) {
            isToastShowing = true

            val toastText = when (state) {
                is GeneratorViewModel.State.Success -> {
                    context.getString(R.string.emojis_copied_hint)
                }
                is GeneratorViewModel.State.Error -> {
                    (state as GeneratorViewModel.State.Error).message
                }
                else -> { null }
            }

            toastText?.let { message ->
                val job = launch {
                    snackbarHostState.showMessage(message)
                }
                delay(snackbarDuration)
                job.cancel()
                isToastShowing = false
                isToastTriggered = false
            }
        }
    }

    PrimaryGeneratorScreen(
        modifier = modifier,
        mainHeaderText = stringResource(R.string.emoji_generator),
        inputValue = uiState.emojis,
        inputValueChange = { changedEmojis ->
            screenViewModel.changeNumberEmojis(changedEmojis)
        },
        onGenerateClick = {
            isToastTriggered = true
            screenViewModel.generateEmojisAndCopy(uiState.emojis)
        },
        onBackButton = { goBackPressed() },
        snackbarHostState = snackbarHostState
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
