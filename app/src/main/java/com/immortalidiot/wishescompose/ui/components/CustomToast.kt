package com.immortalidiot.wishescompose.ui.components

import android.content.Context
import android.widget.Toast

fun customToast(
    context: Context,
    toastText: String
) {
    Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
}
