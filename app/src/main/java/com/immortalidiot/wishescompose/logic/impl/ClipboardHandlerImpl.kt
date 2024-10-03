package com.immortalidiot.wishescompose.logic.impl

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.immortalidiot.wishescompose.logic.ClipboardHandler
import javax.inject.Inject

class ClipboardHandlerImpl @Inject constructor() : ClipboardHandler {
    override suspend fun copy(context: Context, copiedMessage: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("New record", copiedMessage)
        clipboard.setPrimaryClip(clip)
    }

    override suspend fun getLatestRecord(context: Context): String {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = clipboard.primaryClip
        return clip?.getItemAt(0)?.coerceToText(context).toString()
    }
}
