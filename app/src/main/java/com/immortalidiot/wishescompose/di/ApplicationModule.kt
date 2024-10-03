package com.immortalidiot.wishescompose.di

import com.immortalidiot.wishescompose.logic.ClipboardHandler
import com.immortalidiot.wishescompose.logic.EmojiGenerator
import com.immortalidiot.wishescompose.logic.WishGenerator
import com.immortalidiot.wishescompose.logic.impl.ClipboardHandlerImpl
import com.immortalidiot.wishescompose.logic.impl.EmojiGeneratorImpl
import com.immortalidiot.wishescompose.logic.impl.WishGeneratorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

    @Binds
    fun bindEmojiGenerator(impl: EmojiGeneratorImpl): EmojiGenerator

    @Binds
    fun bindWishGenerator(impl: WishGeneratorImpl): WishGenerator

    @Binds
    fun bindClipboardCopier(impl: ClipboardHandlerImpl) : ClipboardHandler
}
