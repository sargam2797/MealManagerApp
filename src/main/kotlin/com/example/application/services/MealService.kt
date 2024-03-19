package com.example.application.services

import com.example.application.model.Meal
import com.example.application.repository.IMealRepository
import org.springframework.stereotype.Service

@Service
class MealService(
    val mealRepository: IMealRepository
) {
    fun getMealOptions(): List<Meal> {
        return mealRepository.findAll().toList()
    }
}