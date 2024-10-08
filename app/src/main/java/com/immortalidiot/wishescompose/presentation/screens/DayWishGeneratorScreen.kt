package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import com.immortalidiot.wishescompose.ui.theme.Constants
import com.immortalidiot.wishescompose.ui.theme.defaultHeaderTextStyle
import com.immortalidiot.wishescompose.ui.theme.wishInHeaderTextStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DayWishGeneratorScreen(
    screenViewModel: GeneratorViewModel,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by screenViewModel.mutableStateFlow.collectAsState()
    val uiState by screenViewModel.uiState.collectAsState()

    val context = LocalContext.current

    val snackbarHostState = LocalSnackbarHostState.current
    val snackbarDuration: Long = Constants.SNACKBAR_DURATION

    var isSnackbarTriggered by remember { mutableStateOf(false) }
    var isSnackbarShowing by remember { mutableStateOf(false) }

    LaunchedEffect(isSnackbarTriggered) {
        if (isSnackbarTriggered && !isSnackbarShowing &&
            (state is GeneratorViewModel.State.Success || state is GeneratorViewModel.State.Error)
        ) {
            isSnackbarShowing = true

            val toastText = when (state) {
                is GeneratorViewModel.State.Success -> {
                    context.getString(R.string.wish_copied_hint)
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
                isSnackbarShowing = false
                isSnackbarTriggered = false
            }
        }
    }

    val headerText = uiState.dayWish ?: stringResource(R.string.number_of_emojis)

    val headerTextStyle = if (uiState.dayWish != null) {
        wishInHeaderTextStyle
    } else {
        defaultHeaderTextStyle
    }

    PrimaryGeneratorScreen(
        modifier = modifier,
        mainHeaderText = stringResource(R.string.day_wish_generator),
        headerText = headerText,
        headerTextStyle = headerTextStyle,
        inputValue = uiState.emojis,
        inputValueChange = { changedEmojis ->
            screenViewModel.changeNumberEmojis(changedEmojis)
        },
        onGenerateClick = {
            isSnackbarTriggered = true
            screenViewModel.generateDayWishAndCopy(uiState.emojis)
        },
        onBackButton = {
            navHostController.popBackStack(
                route = MainScreen.ModeSelectionScreen.route,
                inclusive = false,
                saveState = true
            )
        },
        snackbarHostState = snackbarHostState
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
