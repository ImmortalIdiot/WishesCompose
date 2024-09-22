package com.immortalidiot.wishescompose.logic

interface WishGenerator {
    suspend fun generateDayWish(value: Int) : String
    suspend fun generateNightWish(value: Int) : String
}
