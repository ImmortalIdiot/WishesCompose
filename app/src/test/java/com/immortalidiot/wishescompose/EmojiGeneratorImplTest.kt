package com.immortalidiot.wishescompose

import com.immortalidiot.wishescompose.logic.EmojiGeneratorImpl
import org.junit.Test

import org.junit.Assert.*

class EmojiGeneratorImplTest {
    private val emojiGeneratorImpl = EmojiGeneratorImpl()

    @Test
    fun appropriateAmount() {
        val testLength = 8
        val generatedEmojis = emojiGeneratorImpl.generateEmojis(testLength)
        assertEquals(testLength, generatedEmojis.codePointCount(0, generatedEmojis.length))
    }
}