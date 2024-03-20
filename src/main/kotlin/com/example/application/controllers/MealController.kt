package com.example.application.controllers

import com.example.application.model.MealResponse
import com.example.application.services.MealService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MealController(
    private val mealService: MealService
) {
    @GetMapping("/meal")
    fun getMealsOptions(): MealResponse {
        return mealService.getMealOptions()
    }
}