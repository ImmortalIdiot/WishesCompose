package com.immortalidiot.wishescompose.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun CustomToast(
    context: Context,
    toastText: String
) {
    Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
}
