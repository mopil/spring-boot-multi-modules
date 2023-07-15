package com.example.multiserver.model.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SampleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)