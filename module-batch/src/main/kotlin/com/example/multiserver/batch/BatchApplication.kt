package com.example.multiserver.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.multiserver"])
class BatchApplication

fun main(args: Array<String>) {
    runApplication<BatchApplication>(*args)
}