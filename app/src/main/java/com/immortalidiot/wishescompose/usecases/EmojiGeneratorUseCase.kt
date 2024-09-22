package com.immortalidiot.wishescompose.usecases

import com.immortalidiot.wishescompose.di.Dispatcher
import com.immortalidiot.wishescompose.logic.EmojiGenerator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface EmojiGeneratorUseCase {
    suspend fun generate(value: Int) : String
}

class EmojiGeneratorUseCaseImpl @Inject constructor(
    private val emojiGenerator: EmojiGenerator,
    @Dispatcher(Dispatcher.IO) private val ioDispatcher: CoroutineDispatcher
) : EmojiGeneratorUseCase {

    override suspend fun generate(value: Int): String {
        return withContext(ioDispatcher) {
            emojiGenerator.generate(value = value)
        }
    }
}
