package com.immortalidiot.wishescompose.logic

import android.content.Context

interface ClipboardHandler {
    suspend fun copy(context: Context, copiedMessage: String)
    suspend fun getLatestRecord(context: Context): String?
}
