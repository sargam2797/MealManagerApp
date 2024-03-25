package com.example.application.services

import com.example.application.model.Meal
import com.example.application.model.MealResponse
import com.example.application.model.MealType
import com.example.application.repository.IMealRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MealService(
    val mealRepository: IMealRepository
) {
    fun getMealOptions(): MealResponse {
        val mealOptions = mealRepository.findAll().toList()
        return MealResponse(mealOptions)
    }

    fun getMeal(id: String): Meal {
        val optionalMeal: Optional<Meal> = mealRepository.findById(id)
        return optionalMeal.orElse(null)
    }

    fun modifyMeal(mealIdToUpdate: String, newMealName: String, newMealType: MealType) {
        val mealToUpdate = mealRepository.findById(mealIdToUpdate)
            .orElseThrow { NoSuchElementException("Meal not found with ID: $mealIdToUpdate") }

        mealToUpdate.name = newMealName
        mealToUpdate.type = newMealType

        mealRepository.save(mealToUpdate)
    }
}