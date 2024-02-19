package com.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MealManagerApplication

fun main(args: Array<String>) {
	runApplication<MealManagerApplication>(*args)
}
