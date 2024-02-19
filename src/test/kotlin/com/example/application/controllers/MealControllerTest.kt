package com.example.application.controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MealControllerTest{

    @Test
    internal fun `Returns meal options`() {
        val mealController = MealController()
        val availableMealOptions = listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe")
        val mealsOptions = mealController.getMealsOptions()
        assertEquals(mealsOptions, availableMealOptions)
    }
}