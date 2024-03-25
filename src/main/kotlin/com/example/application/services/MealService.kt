package com.example.application.services

import com.example.application.model.Meal
import com.example.application.model.MealResponse
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

    fun upsertMeal(meal: Meal) {
        if (meal.id != null) {
            val existingMeal = mealRepository.findById(meal.id!!)
            if (existingMeal.isPresent) {
                val mealToUpdate = existingMeal.get()
                if (mealToUpdate.name != meal.name || mealToUpdate.type != meal.type) {
                    mealToUpdate.name = meal.name
                    mealToUpdate.type = meal.type
                    mealRepository.save(mealToUpdate)
                    return
                }
                return
            }
        }
        meal.id = null
        mealRepository.save(meal)
    }
}