package com.immortalidiot.wishescompose.ui.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun HyperlinkedText(
    linkText: String,
    username: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    val localContext = LocalContext.current

    Text(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { openTelegram(context = localContext, username) }
        ),
        text = linkText,
        color = textStyle.color,
        textDecoration = TextDecoration.Underline,
        fontSize = textStyle.fontSize,
        fontStyle = textStyle.fontStyle,
        fontWeight = FontWeight.Bold,
        fontFamily = textStyle.fontFamily
    )
}

private fun openTelegram(context: Context, username: String) {
    try {
        val telegramIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("tg://resolve?domain=$username")
        )
        context.startActivity(telegramIntent)
    } catch (e: ActivityNotFoundException) {
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://t.me/$username")
        )
        context.startActivity(browserIntent)
    }
}
