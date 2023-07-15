package com.example.multiserver.model.domain

import com.example.multiserver.model.domain.QSampleEntity.sampleEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class SampleDslRepository(private val queryFactory: JPAQueryFactory) {
    fun findAll(): List<SampleEntity> {
        return queryFactory.selectFrom(sampleEntity)
            .fetch()
    }
}