package com.example.application.repository

import com.example.application.model.Meal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IMealRepository : CrudRepository<Meal, String>