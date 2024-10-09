package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.SnackbarContainerColor

@Composable
fun CustomSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current

    Box(
        modifier = modifier.fillMaxHeight(0.75f)
    ) {
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = modifier.align(Alignment.BottomCenter)
        ) {
            snackbarData ->
            Snackbar(
                modifier = Modifier.padding(horizontal = dimensions.horizontalNormalPadding),
                containerColor = SnackbarContainerColor,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.wish_icon),
                        modifier = Modifier
                            .padding(end = dimensions.betweenIconAndTextPadding)
                            .size(dimensions.iconSize),
                        contentDescription = "Application icon",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = snackbarData.visuals.message,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
