package com.immortalidiot.wishescompose.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimensions(
    val roundedCorners: Dp = 8.dp,

    val maxWidthTextField: Dp = 100.dp,

    val heightButton: Dp = 54.dp,
    val bigWidthButton: Dp = 290.dp,
    val smallWidthButton: Dp = 216.dp,

    val verticalSmallPadding: Dp = 24.dp,
    val verticalNormalPadding: Dp = 48.dp,
    val verticalBigPadding: Dp = 80.dp,

    val developerTypeTextSize: TextUnit = 28.sp,
    val developerTextSize: TextUnit = 24.sp
)

data class DimensionsTest(
    val maxHeightButtonTest: Dp = 54.dp,
    val maxWidthButtonTest: Dp = 280.dp,
)

val LocalDimensions = compositionLocalOf { Dimensions() }
val LocalTestDimensions = compositionLocalOf { DimensionsTest() }
