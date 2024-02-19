package com.example.application.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MealController {
    @GetMapping("/meal")
    fun getMealsOptions() : List<String> {
        return listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe")
    }
}