package com.immortalidiot.wishescompose.logic.impl

import com.immortalidiot.wishescompose.logic.EmojiGenerator
import kotlin.random.Random

class EmojiGeneratorImpl : EmojiGenerator {
   private val emojis: List<String> = listOf("♥", "💘", "💝", "💖", "💗", "💓", "💞", "💕",
       "❣", "❤", "😻", "🥰", "😍", "😘")

    private val random: Random = Random

    private fun getRandomElement(list: List<String>) : String = list[random.nextInt(list.size)]

    override suspend fun generate(value: Int) : String {
        var generatedEmojis = ""
        repeat(value) {
            generatedEmojis += getRandomElement(emojis)
        }
        return generatedEmojis
    }
}
