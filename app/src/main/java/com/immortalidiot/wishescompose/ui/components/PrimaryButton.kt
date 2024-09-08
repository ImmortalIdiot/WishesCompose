package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.ButtonEnd
import com.immortalidiot.wishescompose.ui.theme.ButtonStart
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.LocalTestDimensions
import com.immortalidiot.wishescompose.ui.theme.buttonText

@Composable
fun PrimaryButton(
    maxHeight: Dp,
    maxWidth: Dp,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current
    val roundedCornerShape = RoundedCornerShape(dimensions.roundedCorners)
    val colors = ButtonDefaults.buttonColors(Color.Transparent)

    Button(
        modifier = modifier
            .height(maxHeight)
            .width(maxWidth)
            .clip(shape = roundedCornerShape)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        ButtonStart,
                        ButtonEnd
                    )
                )
            ),
        colors = colors,
        onClick = onClick
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                style = buttonText,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    val testDimensions = LocalTestDimensions.current

    PrimaryButton(
        maxHeight = testDimensions.maxHeightButtonTest,
        maxWidth = testDimensions.maxWidthButtonTest,
        text = stringResource(id = R.string.emoji_generator),
        onClick = { /*TODO*/ }
    )
}
