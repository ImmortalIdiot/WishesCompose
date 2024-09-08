package com.immortalidiot.wishescompose.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.wishescompose.R
import com.immortalidiot.wishescompose.ui.theme.modeHeaderText

@Composable
fun HeaderText(
    text: String,
    textStyle: TextStyle
) {
    Text(
        text = text,
        style = textStyle,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun ModeHeaderTextPreview() {
    HeaderText(
        text = stringResource(id = R.string.selection_mode),
        textStyle = modeHeaderText
    )
}
