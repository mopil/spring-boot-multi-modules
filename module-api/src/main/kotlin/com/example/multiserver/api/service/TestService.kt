package com.example.multiserver.api.service

import com.example.multiserver.model.domain.SampleRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val sampleRepository: SampleRepository
) {
}