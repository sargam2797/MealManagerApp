package com.example.application.controllers

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

        val availableMealOptions = listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe")

        Mockito.`when`(mealService.getMealOptions())
            .thenReturn(listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe"))

        val mealsOptions = mealController.getMealsOptions()

        assertEquals(mealsOptions, availableMealOptions)
    }
}