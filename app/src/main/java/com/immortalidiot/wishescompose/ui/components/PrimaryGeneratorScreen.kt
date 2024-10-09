package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.defaultHeaderTextStyle
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun PrimaryGeneratorScreen(
    mainHeaderText: String,
    inputValueChange: (String) -> Unit,
    onGenerateClick: () -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    headerText: String = stringResource(R.string.number_of_emojis),
    headerTextStyle: TextStyle = defaultHeaderTextStyle,
    onBackButton: () -> Unit,
    inputValue: String = ""
) {
    val dimensions = LocalDimensions.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = dimensions.verticalBigPadding)
            .pointerInput(Unit) {
                detectTapGestures {
                    hideKeyboardAndClearFocus(
                        keyboardController = keyboardController,
                        focusManager = focusManager
                    )
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderText(
                text = mainHeaderText,
                textStyle = modeHeaderText.copy(color = Color.White)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensions.verticalSmallPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderText(
                    text = headerText,
                    textStyle = headerTextStyle
                )
                GeneratorTextField(
                    value = inputValue,
                    onValueChange = inputValueChange,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            hideKeyboardAndClearFocus(
                                keyboardController = keyboardController,
                                focusManager = focusManager
                            )
                        }
                    )
                )
                PrimaryButton(
                    modifier = modifier,
                    maxWidth = dimensions.generateWidthButton,
                    maxHeight = dimensions.heightButton,
                    text = stringResource(R.string.generate),
                    onClick = {
                        onGenerateClick()
                        if (inputValue.isNotEmpty()) {
                            hideKeyboardAndClearFocus(
                                keyboardController = keyboardController,
                                focusManager = focusManager
                            )
                        }
                    }
                )
            }
            BackButton(
                modifier = Modifier.padding(bottom = dimensions.verticalSmallPadding),
                onClick = onBackButton
            )
        }

        CustomSnackbar(
            snackbarHostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}


private fun hideKeyboardAndClearFocus(
    keyboardController: SoftwareKeyboardController?,
    focusManager: FocusManager
) {
    keyboardController?.hide()
    focusManager.clearFocus()
}

@Preview
@Composable
fun PrimaryGeneratorScreenPreview() {
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
        PrimaryGeneratorScreen(
            mainHeaderText = "Заголовок",
            inputValueChange = {},
            onGenerateClick = {},
            onBackButton = {},
            snackbarHostState = remember { SnackbarHostState() }
        )
    }
}
