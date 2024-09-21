package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.main.MainScreen
import com.immortalidiot.wishescompose.ui.components.BackButton
import com.immortalidiot.wishescompose.ui.components.GeneratorTextField
import com.immortalidiot.wishescompose.ui.components.HeaderText
import com.immortalidiot.wishescompose.ui.components.PrimaryButton
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.headerText
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun DayWishGeneratorScreen(
    // TODO: add view model
    navHostController: NavHostController,
    modifier: Modifier = Modifier
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
            text = stringResource(R.string.day_wish_generator),
            textStyle = modeHeaderText.copy(color = Color.White)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensions.verticalSmallPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(
                text = stringResource(R.string.number_of_emojis),
                textStyle = headerText.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            GeneratorTextField(
                onValueChange = {
                    // TODO: implement view model
                }
            )
            PrimaryButton(
                modifier = modifier,
                maxWidth = dimensions.generateWidthButton,
                maxHeight = dimensions.heightButton,
                text = stringResource(R.string.generate),
                onClick = {
                    // TODO: generate day wish
                }
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
fun DayWishGeneratorScreenPreview() {
    DayWishGeneratorScreen(navHostController = rememberNavController())
}
