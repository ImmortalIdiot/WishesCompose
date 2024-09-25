package com.immortalidiot.wishescompose.logic

interface ClipboardCopier {
    suspend fun copy(copiedMessage: String)
}
