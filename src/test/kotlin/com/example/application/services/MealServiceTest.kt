package com.example.application.services

import com.example.application.model.Meal
import com.example.application.model.MealType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MealServiceTest {
    @Test
    internal fun `return list of meal items`() {
        val mealService = MealService()
        val availableMealOptions = listOf(
            Meal("Poha", MealType.BREAKFAST),
            Meal("Upma", MealType.BREAKFAST),
            Meal("Omelette", MealType.BREAKFAST),
            Meal("Daal-rice", MealType.LUNCH),
            Meal("Pasta", MealType.LUNCH),
            Meal("Parathe", MealType.DINNER),
        )
        val mealOptions = mealService.getMealOptions()
        assertEquals(mealOptions, availableMealOptions)
    }
}