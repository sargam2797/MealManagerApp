package com.example.application.services

import com.example.application.model.MealResponse
import com.example.application.repository.IMealRepository
import org.springframework.stereotype.Service

@Service
class MealService(
    val mealRepository: IMealRepository
) {
    fun getMealOptions(): MealResponse {
        val mealOptions = mealRepository.findAll().toList()
        return MealResponse(mealOptions)
    }
}