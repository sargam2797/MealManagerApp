package com.example.application.controllers

import com.example.application.model.Meal
import com.example.application.model.MealResponse
import com.example.application.model.MealType
import com.example.application.services.MealService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.mock.mockito.MockBean

internal class MealControllerTest {
    @MockBean
    var mealService: MealService = mock()
    private val mealController = MealController(mealService)

    @Test
    internal fun `Returns meal options`() {
        val availableMealOptions = MealResponse(
            listOf(
                Meal("1", "Poha", MealType.BREAKFAST),
                Meal("2", "Upma", MealType.BREAKFAST),
                Meal("3", "Omelette", MealType.BREAKFAST),
                Meal("4", "Daal-rice", MealType.LUNCH),
                Meal("5", "Pasta", MealType.LUNCH),
                Meal("6", "Parathe", MealType.DINNER),
            )
        )

        `when`(mealService.getMealOptions())
            .thenReturn(availableMealOptions)

        val mealsOptions = mealController.getMealsOptions()

        assertEquals(mealsOptions, availableMealOptions)
    }

    @Test
    internal fun `should modify the meal item`() {
        val updateMealRequest = Meal("1", "Boiled Eggs", MealType.BREAKFAST)

        `when`(mealService.upsertMeal(Meal("1", "Boiled Eggs", MealType.BREAKFAST))).then {
            updateMealRequest.name = "Boiled Eggs"
            Unit
        }

        mealController.upsertMeal("1", updateMealRequest)

        verify(mealService).upsertMeal(updateMealRequest)

        assertEquals("Boiled Eggs", updateMealRequest.name)
    }
}