package com.immortalidiot.wishescompose.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val roundedCorners: Dp = 8.dp,

    val maxWidthTextField: Dp = 100.dp,

    val heightButton: Dp = 54.dp,
    val bigWidthButton: Dp = 290.dp,
    val smallWidthButton: Dp = 216.dp,

    val verticalSmallPadding: Dp = 24.dp,
    val verticalBigPadding: Dp = 80.dp
)

data class DimensionsTest(
    val maxHeightButtonTest: Dp = 54.dp,
    val maxWidthButtonTest: Dp = 280.dp,
)

val LocalDimensions = compositionLocalOf { Dimensions() }
val LocalTestDimensions = compositionLocalOf { DimensionsTest() }
