package com.example.application.services

import org.springframework.stereotype.Service


@Service
class MealService {
    fun getMealOptions() : List<String>{
        return listOf("Poha", "Upma", "Omlette", "Daal-rice", "Pasta", "Parathe")
    }
}