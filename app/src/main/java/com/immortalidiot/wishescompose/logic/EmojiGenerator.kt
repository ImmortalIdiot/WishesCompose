package com.immortalidiot.wishescompose.logic

interface EmojiGenerator {
    suspend fun generate(value: Int) : String
}
