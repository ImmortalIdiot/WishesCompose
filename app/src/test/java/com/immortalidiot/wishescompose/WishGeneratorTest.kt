package com.immortalidiot.wishescompose

import com.immortalidiot.wishescompose.logic.WishGenerator

import org.junit.Assert.*
import org.junit.Test

class WishGeneratorTest {
    private val wishGenerator = WishGenerator()

    @Test
    fun isValidDayWishTest() {
        val wish = wishGenerator.generateDayWish()
        val validDayWish = wishGenerator.dayList.any { wish.contains(it) } &&
                wishGenerator.compliments.any { wish.contains(it) }
        assertTrue(validDayWish)
    }

    @Test
    fun isValidNightWishTest() {
        val wish = wishGenerator.generateNightWish()
        val validNightWish = wishGenerator.nightList.any { wish.contains(it) } &&
                wishGenerator.compliments.any { wish.contains(it) }
        assertTrue(validNightWish)
    }
}
