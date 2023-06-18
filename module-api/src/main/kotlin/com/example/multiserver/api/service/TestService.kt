package com.example.multiserver.api.service

import com.example.multiserver.model.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testRepository: TestRepository
) {
}