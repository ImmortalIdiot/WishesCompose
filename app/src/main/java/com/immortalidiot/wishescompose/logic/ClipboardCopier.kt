package com.immortalidiot.wishescompose.logic

import android.content.Context

interface ClipboardCopier {
    suspend fun copy(context: Context, copiedMessage: String)
}
