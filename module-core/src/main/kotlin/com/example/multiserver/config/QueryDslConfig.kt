package com.example.multiserver.config

import com.querydsl.jpa.impl.JPAQueryFactory
import javax.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig {
    @Bean
    fun jpaQueryFactory(em: EntityManager) = JPAQueryFactory(em)
}