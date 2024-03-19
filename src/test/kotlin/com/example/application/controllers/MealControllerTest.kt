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
            Meal("1","Poha", MealType.BREAKFAST),
            Meal("2","Upma", MealType.BREAKFAST),
            Meal("3","Omelette", MealType.BREAKFAST),
            Meal("4","Daal-rice", MealType.LUNCH),
            Meal("5","Pasta", MealType.LUNCH),
            Meal("6","Parathe", MealType.DINNER),
        )

        Mockito.`when`(mealService.getMealOptions())
            .thenReturn(availableMealOptions)

        val mealsOptions = mealController.getMealsOptions()

        assertEquals(mealsOptions, availableMealOptions)
    }
}