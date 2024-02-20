package com.example.application.services

import com.example.application.model.Meal
import com.example.application.model.MealType
import org.springframework.stereotype.Service


@Service
class MealService {
    fun getMealOptions(): List<Meal> {
        return displayMealOptions()
    }

    private fun displayMealOptions() = listOf(
        Meal("Poha", MealType.BREAKFAST),
        Meal("Upma", MealType.BREAKFAST),
        Meal("Omelette", MealType.BREAKFAST),
        Meal("Daal-rice", MealType.LUNCH),
        Meal("Pasta", MealType.LUNCH),
        Meal("Parathe", MealType.DINNER),
    )
}