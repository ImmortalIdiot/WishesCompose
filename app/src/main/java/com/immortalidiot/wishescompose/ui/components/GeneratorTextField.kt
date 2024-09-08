package com.immortalidiot.wishescompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.LocalDimensions
import com.immortalidiot.wishescompose.ui.theme.hintText

@Composable
fun GeneratorTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current
    val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent
    )

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.width(dimensions.maxWidthTextField),
        textStyle = hintText,
        placeholder = {
            Text(
                text = stringResource(id = R.string.min_and_max_hint),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        colors = colors,
        keyboardOptions = keyboardOptions
    )
}

@Preview
@Composable
fun GeneratorTextFieldPreview() {
    GeneratorTextField(
        value = "",
        onValueChange = { TODO() },
    )
}
