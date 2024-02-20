package com.example.application.controllers

import com.example.application.model.Meal
import com.example.application.model.MealType
import com.example.application.services.MealService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.springframework.boot.test.mock.mockito.MockBean

internal class MealControllerTest {
    @MockBean
    var mealService: MealService = mock()

    @Test
    internal fun `Returns meal options`() {
        val mealController = MealController(mealService)

        val availableMealOptions = listOf(
            Meal("Poha", MealType.BREAKFAST),
            Meal("Upma", MealType.BREAKFAST),
            Meal("Omelette", MealType.BREAKFAST),
            Meal("Daal-rice", MealType.LUNCH),
            Meal("Pasta", MealType.LUNCH),
            Meal("Parathe", MealType.DINNER),
        )

        Mockito.`when`(mealService.getMealOptions())
            .thenReturn(availableMealOptions)

        val mealsOptions = mealController.getMealsOptions()

        assertEquals(mealsOptions, availableMealOptions)
    }
}