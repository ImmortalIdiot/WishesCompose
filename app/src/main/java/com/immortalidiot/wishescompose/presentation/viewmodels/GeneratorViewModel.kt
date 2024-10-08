package com.immortalidiot.wishescompose.presentation.viewmodels

import android.content.Context
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.wishescompose.logic.ClipboardHandler
import com.immortalidiot.wishescompose.logic.EmojiGenerator
import com.immortalidiot.wishescompose.logic.WishGenerator
import com.immortalidiot.wishescompose.ui.models.GeneratorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(
    private val emojiGenerator: EmojiGenerator,
    private val wishGenerator: WishGenerator,
    private val clipboardHandler: ClipboardHandler,
    @ApplicationContext private val context: Context
) : ViewModel() {

    @Immutable
    sealed class State {
        data object Init : State()
        data class Success(val wish: String?) : State()
        data class Error(val message: String) : State()
    }

    val mutableStateFlow = MutableStateFlow<State>(State.Init)

    private val _uiState = MutableStateFlow(GeneratorModel(emojis = String()))
    val uiState: StateFlow<GeneratorModel> = _uiState.asStateFlow()

    fun resetState() = mutableStateFlow.update { State.Init }

    private fun updateStateWithError(errorMessage: String = DEFAULT_ERROR_MESSAGE) =
        mutableStateFlow.update { State.Error(errorMessage) }

    private fun updateStateWithSuccess(message: String? = null) =
        mutableStateFlow.update { State.Success(message) }

    fun changeNumberEmojis(emojis: String) =
        _uiState.update { uiState.value.copy(emojis = emojis) }

    fun generateEmojisAndCopy(numberEmojis: String) {
        if (numberEmojis.isNotEmpty()) {
            val emojis = numberEmojis.toInt()
            copyGeneratedEmojis {
                emojiGenerator.generate(emojis)
            }
        } else { updateStateWithError() }
    }

    private fun copyGeneratedEmojis(generateEmojis: suspend () -> String) {
        viewModelScope.launch {
            clipboardHandler.copy(context = context, copiedMessage = generateEmojis())
            updateStateWithSuccess()
        }
    }

    fun generateDayWishAndCopy(numberEmojis: String) {
        if (numberEmojis.isNotEmpty()) {
            val emojis = numberEmojis.toInt()
            copyGeneratedWish {
                val wishWithEmojis = wishGenerator.generateDayWish() + emojiGenerator.generate(emojis)
                val extractedWish = extractWish(wishWithEmojis)
                updateUiStateWithWish(extractedWish, true)
                wishWithEmojis
            }
        } else { updateStateWithError() }
    }

    fun generateNightWishAndCopy(numberEmojis: String) {
        if (numberEmojis.isNotEmpty()) {
            val emojis = numberEmojis.toInt()
            copyGeneratedWish {
                val wishWithEmojis = wishGenerator.generateNightWish() + emojiGenerator.generate(emojis)
                val extractedWish = extractWish(wishWithEmojis)
                updateUiStateWithWish(extractedWish, false)
                wishWithEmojis
            }
        } else { updateStateWithError() }
    }

    private fun copyGeneratedWish(generateWish: suspend () -> String) {
        viewModelScope.launch {
            clipboardHandler.copy(context = context, copiedMessage = generateWish())
        }
    }

    private fun updateUiStateWithWish(wish: String, isDayWish: Boolean) {
        _uiState.update { currentState ->
            if (isDayWish) {
                currentState.copy(dayWish = wish)
            } else {
                currentState.copy(nightWish = wish)
            }
        }
        updateStateWithSuccess(wish)
    }

    private fun extractWish(fullText: String): String {
        val regex = "[\\p{So}\\p{Cn}]".toRegex()
        return fullText.split(regex).firstOrNull()?.trim() ?: fullText
    }

    companion object {
        private const val DEFAULT_ERROR_MESSAGE = "Введите количество эмоджи"
    }
}
