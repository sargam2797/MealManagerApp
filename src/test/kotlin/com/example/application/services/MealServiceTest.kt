package com.example.application.services

import com.example.application.model.Meal
import com.example.application.model.MealResponse
import com.example.application.model.MealType
import com.example.application.repository.IMealRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.util.*

internal class MealServiceTest {
    private val mealRepository = mock<IMealRepository>()

    private val mealService = MealService(mealRepository)

    @Test
    internal fun `return list of meal items`() {
        val availableMealOptions = listOf(
            Meal("1", "Poha", MealType.BREAKFAST),
            Meal("2", "Upma", MealType.BREAKFAST),
            Meal("3", "Omelette", MealType.BREAKFAST),
            Meal("4", "Daal-rice", MealType.LUNCH),
            Meal("5", "Pasta", MealType.LUNCH),
            Meal("6", "Parathe", MealType.DINNER),
        )
        `when`(mealRepository.findAll()).thenReturn(availableMealOptions)

        val mealOptions = mealService.getMealOptions()
        assertEquals(mealOptions, MealResponse(availableMealOptions))
    }

    @Test
    internal fun `return a meal item`() {
        val meal = Meal("1", "Poha", MealType.BREAKFAST)
        `when`(mealRepository.findById("1")).thenReturn(Optional.of(meal))

        val expectedMeal = mealService.getMeal("1")
        assertEquals(expectedMeal, meal)
    }

    @Test
    internal fun `should modify the meal item`() {
        val mealToUpdate = Meal("1", "Poha", MealType.BREAKFAST)
        val mealIdToUpdate = "1"

        `when`(mealRepository.findById(mealIdToUpdate)).thenReturn(Optional.of(mealToUpdate))

        mealService.modifyMeal(mealIdToUpdate, "Boiled Eggs", MealType.BREAKFAST)

        assertEquals("Boiled Eggs", mealToUpdate.name)

        verify(mealRepository).findById(mealIdToUpdate)
        verify(mealRepository).save(mealToUpdate)
    }
}