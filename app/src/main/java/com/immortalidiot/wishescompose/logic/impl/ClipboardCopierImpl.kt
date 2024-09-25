package com.immortalidiot.wishescompose.logic.impl

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.immortalidiot.wishescompose.logic.ClipboardCopier
import javax.inject.Inject

class ClipboardCopierImpl @Inject constructor() : ClipboardCopier {
    override suspend fun copy(context: Context, copiedMessage: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("New record", copiedMessage)
        clipboard.setPrimaryClip(clip)
    }
}
