package com.immortalidiot.wishescompose.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.navigation.MainScreen
import com.immortalidiot.wishescompose.ui.components.BackButton
import com.immortalidiot.wishescompose.ui.components.HeaderText
import com.immortalidiot.wishescompose.ui.components.HyperlinkedText
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.headerText

@Composable
fun DevelopersScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current
    val developerTypeTextStyle = headerText.copy(
        fontSize = dimensions.developerTypeTextSize,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    val developerTextStyle = developerTypeTextStyle.copy(
        fontSize = dimensions.developerTextSize
    )

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderText(
                text = stringResource(R.string.developer),
                textStyle = developerTypeTextStyle
            )
            HyperlinkedText(
                linkText = stringResource(R.string.Immortal_Idiot),
                username = stringResource(R.string.Immortal_Idiot),
                textStyle = developerTextStyle,
                modifier = modifier
            )
            Spacer(modifier = modifier.height(dimensions.verticalNormalPadding))
            HeaderText(
                text = stringResource(R.string.designer),
                textStyle = developerTypeTextStyle
            )
            HyperlinkedText(
                linkText = stringResource(R.string.kipish_080),
                username = stringResource(R.string.kipish_080),
                textStyle = developerTextStyle,
                modifier = modifier
            )
        }
        BackButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = dimensions.verticalBigPadding),
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
