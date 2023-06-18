package com.example.multiserver.model

import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<TestEntity, Long> {
}