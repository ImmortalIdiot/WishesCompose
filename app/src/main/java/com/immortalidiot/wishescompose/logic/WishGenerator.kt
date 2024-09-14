package com.immortalidiot.wishescompose.logic

import kotlin.random.Random

class WishGenerator {
    private val dayList: List<String> = listOf("Доброе утро",
        "Доброе утречко", "С добрым утречком", "С добрым утром")

    private val nightList: List<String> = listOf("Споки ноки",
        "Спокойной ночи", "Спокойной ночки", "Сладких снов")

    private val compliments = listOf("моя принцесса", "моя зайка", "моё солнышко", "моя крошка",
        "моя сладкая", "моя красавица", "моя красотка")

    private val random: Random = Random

    private fun getRandomElement(list: List<String>) : String = list[random.nextInt(list.size)]

    private fun getRandomIntegerValue(from: Int = 0, until: Int = 150) =
        if (from > until) { random.nextInt(from, until + 1) }
        else { 0 }

    fun generateDayWish() : String {
        val chance = getRandomIntegerValue()
        val wish = getRandomElement(dayList)
        return if (chance < 140) { wish + ", " + getRandomElement(compliments) }
        else { wish }
    }

    fun generateNightWish() : String {
        var chance = getRandomIntegerValue()
        val nightWish: String = if (chance > 135) {
            "Споки ноки нежно в щёки"
        } else if (chance > 130) {
            "Споки ноки в обе щёки"
        } else {
            getRandomElement(nightList)
        }

        chance = getRandomIntegerValue()
        return if (chance < 140) { nightWish + ", " + getRandomElement(compliments) }
        else { nightWish }
    }
}
