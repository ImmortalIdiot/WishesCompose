package com.immortalidiot.wishescompose

import com.immortalidiot.wishescompose.logic.impl.WishGeneratorImpl
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*
import org.junit.Test

class WishGeneratorImplTest {
    private val wishGeneratorImpl = WishGeneratorImpl()

    @Test
    fun isValidDayWishTest() = runTest {
        val wish = wishGeneratorImpl.generateDayWish()
        val validDayWish = wishGeneratorImpl.dayList.any { wish.contains(it) } &&
                wishGeneratorImpl.compliments.any { wish.contains(it) }
        assertTrue(validDayWish)
    }

    @Test
    fun isValidNightWishTest() = runTest {
        val wish = wishGeneratorImpl.generateNightWish()
        val validNightWish = wishGeneratorImpl.nightList.any { wish.contains(it) } &&
                wishGeneratorImpl.compliments.any { wish.contains(it) }
        assertTrue(validNightWish)
    }
}
