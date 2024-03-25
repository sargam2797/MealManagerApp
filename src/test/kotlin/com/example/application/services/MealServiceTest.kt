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
    internal fun `should modify the meal item`() {
        val existingMeal = Meal("1", "Boiled Eggs", MealType.BREAKFAST)
        val mealToUpdate = Meal("1", "Pasta", MealType.DINNER)

        `when`(mealRepository.findById("1")).thenReturn(Optional.of(existingMeal))

        mealService.upsertMeal(mealToUpdate)

        assertEquals("Pasta", mealToUpdate.name)

        verify(mealRepository).findById("1")
        verify(mealRepository).save(existingMeal)
    }

    @Test
    internal fun `should insert a meal if nothing to update`() {
        val newMeal = Meal(null, "Pasta", MealType.DINNER)
        val savedMeal = Meal("1", "Pasta", MealType.DINNER)

        `when`(mealRepository.save(any(Meal::class.java))).thenReturn(savedMeal)

        mealService.upsertMeal(newMeal)

        assertEquals(savedMeal.name, "Pasta")
        verify(mealRepository).save(newMeal)
    }
}