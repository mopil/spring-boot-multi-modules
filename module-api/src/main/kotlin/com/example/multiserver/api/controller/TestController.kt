package com.example.multiserver.api.controller

import com.example.multiserver.api.dto.TestDto
import com.example.multiserver.api.service.TestService
import com.example.multiserver.client.SlackClient
import com.example.multiserver.model.domain.CompositeKeyEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService,
    private val slackClient: SlackClient
) {

    @GetMapping(Uris.Test.TEST)
    fun test() {
        testService.get()
    }
}