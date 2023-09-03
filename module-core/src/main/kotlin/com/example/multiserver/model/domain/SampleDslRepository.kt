package com.example.multiserver.model.domain

import com.example.multiserver.model.domain.QOneKeyEntity.oneKeyEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class SampleDslRepository(private val queryFactory: JPAQueryFactory) {
    fun findAll(): List<OneKeyEntity> {
        return queryFactory.selectFrom(oneKeyEntity)
            .fetch()
    }
}