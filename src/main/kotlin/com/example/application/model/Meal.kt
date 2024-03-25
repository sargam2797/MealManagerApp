package com.example.application.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.NoRepositoryBean

@Table("MEAL")
@NoRepositoryBean
data class Meal(
    @Id var id: String,
    var name: String,
    var type: MealType,
)

data class MealResponse(
    val mealOptions: List<Meal>
)

data class UpdateMealRequest(
    var name: String,
    var type: MealType
)