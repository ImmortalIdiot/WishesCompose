package com.immortalidiot.wishescompose.logic

import android.text.InputFilter
import android.text.Spanned

class InputFilter(
    private val min: Int,
    private val max: Int
) : InputFilter {

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = Integer.parseInt(dest.toString() + source.toString())
            if (isInRange(min, max, input)) { return null }
        } catch (e: NumberFormatException) {
            /* do nothing */
        }
        return ""
    }

    private fun isInRange(min: Int, max: Int, input: Int): Boolean =
        if (max > min) { input in min..max }
        else { input in max..min }
}
