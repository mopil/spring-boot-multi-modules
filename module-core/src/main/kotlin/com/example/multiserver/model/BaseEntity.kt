package com.example.multiserver.model

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()
}