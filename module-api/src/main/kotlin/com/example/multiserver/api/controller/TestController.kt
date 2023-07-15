package com.example.multiserver.api.controller

import com.example.multiserver.api.dto.TestDto
import com.example.multiserver.api.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {

    @GetMapping(Uris.Test.TEST)
    fun test(@RequestBody testDto: TestDto): TestDto {
        return TestDto("test")
    }
}