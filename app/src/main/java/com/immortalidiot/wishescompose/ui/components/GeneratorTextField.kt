package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import com.immortalidiot.wishescompose.ui.theme.HintColor
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.hintText

@Composable
fun GeneratorTextField(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    value: String = "",
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    val dimensions = LocalDimensions.current
    val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)

    val inputColor = if (value.isEmpty()) { HintColor } else { Color.White }
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        cursorColor = Color.White
    )

    val minNumber = 1
    val maxNumber = 2000

    TextField(
        value = value,
        onValueChange = { input ->
            val number = input.toIntOrNull()
            if (number != null && number in minNumber..maxNumber) {
                onValueChange(input)
            }
        },
        modifier = modifier.width(dimensions.maxWidthTextField),
        textStyle = hintText.copy(
            color = inputColor,
            textAlign = TextAlign.Center
        ),
        placeholder = {
            Text(
                text = stringResource(id = R.string.min_and_max_hint),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = inputColor
            )
        },
        colors = colors,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true
    )
}

@Preview
@Composable
fun GeneratorTextFieldPreview() {
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
        GeneratorTextField(
            value = "",
            onValueChange = { TODO() },
        )
    }
}
