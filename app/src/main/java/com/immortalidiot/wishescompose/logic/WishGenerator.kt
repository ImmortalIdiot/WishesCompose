package com.immortalidiot.wishescompose.logic

interface WishGenerator {
    suspend fun generateDayWish() : String
    suspend fun generateNightWish() : String
}
