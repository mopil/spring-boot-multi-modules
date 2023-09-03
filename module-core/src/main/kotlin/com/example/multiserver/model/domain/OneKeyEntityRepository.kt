package com.example.multiserver.model.domain

import org.springframework.data.jpa.repository.JpaRepository

interface OneKeyEntityRepository : JpaRepository<OneKeyEntity, Long> {
}