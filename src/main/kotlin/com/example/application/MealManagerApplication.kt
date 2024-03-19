package com.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories(basePackages = ["com.example.application.repository"])
class MealManagerApplication

fun main(args: Array<String>) {
	runApplication<MealManagerApplication>(*args)
}
