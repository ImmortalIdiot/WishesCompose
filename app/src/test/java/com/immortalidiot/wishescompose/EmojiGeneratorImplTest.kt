package com.immortalidiot.wishescompose

import com.immortalidiot.wishescompose.logic.impl.EmojiGeneratorImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

class EmojiGeneratorImplTest {
    private val emojiGeneratorImpl = EmojiGeneratorImpl()

    @Test
    fun appropriateAmount() = runTest {
        val testLength = 8
        val generatedEmojis = emojiGeneratorImpl.generate(testLength)
        assertEquals(testLength, generatedEmojis.codePointCount(0, generatedEmojis.length))
    }
}