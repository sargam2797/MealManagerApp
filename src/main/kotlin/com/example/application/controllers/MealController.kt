package com.example.application.controllers

import com.example.application.model.Meal
import com.example.application.model.MealResponse
import com.example.application.services.MealService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/meals")
class MealController(
    private val mealService: MealService
) {
    @GetMapping
    fun getMealsOptions(): MealResponse {
        return mealService.getMealOptions()
    }

    @PutMapping("/{mealId}")
    fun upsertMeal(@PathVariable mealId: String, @RequestBody updateMealRequest: Meal) {
        mealService.upsertMeal(updateMealRequest)
    }
}