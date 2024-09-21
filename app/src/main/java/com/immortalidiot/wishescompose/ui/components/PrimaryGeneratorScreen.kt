package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.main.MainScreen
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun PrimaryGeneratorScreen(
    navHostController: NavHostController,
    headerText: String,
    inputValueChange: (String) -> Unit,
    onGenerateClick: () -> Unit,
    modifier: Modifier = Modifier,
    inputValue: String = ""
) {
    val dimensions = LocalDimensions.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = dimensions.verticalBigPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderText(
            text = headerText,
            textStyle = modeHeaderText.copy(color = Color.White)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensions.verticalSmallPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(
                text = stringResource(R.string.number_of_emojis),
                textStyle = com.immortalidiot.wishescompose.ui.theme.headerText.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            GeneratorTextField(
                value = inputValue,
                onValueChange = inputValueChange
            )
            PrimaryButton(
                modifier = modifier,
                maxWidth = dimensions.generateWidthButton,
                maxHeight = dimensions.heightButton,
                text = stringResource(R.string.generate),
                onClick = onGenerateClick
            )
        }
        BackButton(
            modifier = modifier,
            onClick = {
                navHostController.popBackStack(
                    route = MainScreen.ModeSelectionScreen.route,
                    inclusive = false,
                    saveState = true
                )
            }
        )
    }
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
            navHostController = rememberNavController(),
            headerText = "Заголовок",
            inputValueChange = {},
            onGenerateClick = {},
        )
    }
}
