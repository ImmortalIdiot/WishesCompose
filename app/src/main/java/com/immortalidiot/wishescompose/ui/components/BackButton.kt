package com.immortalidiot.wishescompose.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current

    PrimaryButton(
        modifier = modifier,
        maxHeight = dimensions.heightButton,
        maxWidth = dimensions.widthBackButton,
        text = stringResource(R.string.back),
        onClick = onClick
    )
}
