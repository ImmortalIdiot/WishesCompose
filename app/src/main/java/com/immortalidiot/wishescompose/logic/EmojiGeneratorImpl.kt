package com.immortalidiot.wishescompose.logic

import kotlin.random.Random

class EmojiGeneratorImpl {
   private val emojis: List<String> = listOf("♥", "💘", "💝", "💖", "💗", "💓", "💞", "💕",
       "❣", "❤", "😻", "🥰", "😍", "😘")

    private val random: Random = Random

    private fun getRandomElement(list: List<String>) : String = list[random.nextInt(list.size)]

    fun generateEmojis(value: Int) : String {
        var generatedEmojis = ""
        repeat(value) {
            generatedEmojis += getRandomElement(emojis)
        }
        return generatedEmojis
    }
}
