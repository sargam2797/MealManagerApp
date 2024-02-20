package com.example.application.services

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MealServiceTest {
    @Test
    internal fun `return list of meal items`() {
        val mealService = MealService()
        val availableMealOptions = listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe")
        val mealOptions = mealService.getMealOptions()
        assertEquals(mealOptions, availableMealOptions)
    }
}