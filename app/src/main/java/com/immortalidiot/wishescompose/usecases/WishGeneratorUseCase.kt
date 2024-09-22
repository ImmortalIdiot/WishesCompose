package com.immortalidiot.wishescompose.usecases

import com.immortalidiot.wishescompose.di.Dispatcher
import com.immortalidiot.wishescompose.logic.WishGenerator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface WishGeneratorUseCase {
    suspend fun generateDayWish() : String
    suspend fun generateNightWish() : String
}

class WishGeneratorUseCaseImpl @Inject constructor(
    private val wishGenerator: WishGenerator,
    @Dispatcher(Dispatcher.IO) private val ioDispatcher: CoroutineDispatcher
) : WishGeneratorUseCase {

    override suspend fun generateDayWish(): String {
        return withContext(ioDispatcher) {
            wishGenerator.generateDayWish()
        }
    }

    override suspend fun generateNightWish(): String {
        return withContext(ioDispatcher) {
            wishGenerator.generateNightWish()
        }
    }
}
