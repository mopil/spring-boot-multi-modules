package com.example.multiserver.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.multiserver"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}