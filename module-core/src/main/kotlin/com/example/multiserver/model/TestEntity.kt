package com.example.multiserver.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class TestEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)