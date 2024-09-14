package com.immortalidiot.wishescompose

import com.immortalidiot.wishescompose.logic.EmojiGenerator
import org.junit.Test

import org.junit.Assert.*

class EmojiGeneratorTest {
    private val emojiGenerator = EmojiGenerator()

    @Test
    fun appropriateAmount() {
        val testLength = 8
        val generatedEmojis = emojiGenerator.generateEmojis(testLength)
        assertEquals(testLength, generatedEmojis.codePointCount(0, generatedEmojis.length))
    }
}