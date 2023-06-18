package com.example.multiserver.api.controller

import com.example.multiserver.api.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {

    @GetMapping
    fun test(): String {
        return "test"
    }
}