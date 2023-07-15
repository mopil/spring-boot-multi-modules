package com.example.multiserver.configuration

import com.querydsl.jpa.impl.JPAQueryFactory
import javax.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfiguration {
    @Bean
    fun jpaQueryFactory(em: EntityManager) = JPAQueryFactory(em)
}