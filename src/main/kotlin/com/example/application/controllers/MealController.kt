package com.example.application.controllers

import com.example.application.model.Meal
import com.example.application.services.MealService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class MealController(
    @Autowired
    private val mealService: MealService
) {

    @GetMapping("/meal")
    fun getMealsOptions(): List<Meal> {
        return mealService.getMealOptions()
    }
}