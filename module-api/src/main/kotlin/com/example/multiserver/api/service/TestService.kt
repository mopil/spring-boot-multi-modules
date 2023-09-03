package com.example.multiserver.api.service

import com.example.multiserver.model.domain.*
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.transaction.Transactional

@Service
class TestService(
        private val oneKeyEntityRepository: OneKeyEntityRepository,
        private val compositeKeyEntityRepository: CompositeKeyEntityRepository
) {
    @PostConstruct
    @Transactional
    fun init() {
        oneKeyEntityRepository.save(
                OneKeyEntity()
        )
        oneKeyEntityRepository.save(
                OneKeyEntity()
        )
        compositeKeyEntityRepository.save(CompositeKeyEntity(
                id = CompositeKey(
                        1, "A"
                ),
                value = "값1"
        ))
        compositeKeyEntityRepository.save(CompositeKeyEntity(
                id = CompositeKey(
                        2, "B"
                ),
                value = "값2"
        ))
        compositeKeyEntityRepository.save(CompositeKeyEntity(
                id = CompositeKey(
                        3, "C"
                ),
                value = "값3"
        ))
    }

    fun get() {
        val oneMap = oneKeyEntityRepository.findAll().associateWith { it.id }
        val oneKeyFirst = oneKeyEntityRepository.findById(1).orElseThrow()
        val oneKeySecond = oneKeyEntityRepository.findById(1).orElseThrow()
        println("단일키 두 엔티티가 동일한가? : ${oneKeyFirst == oneKeySecond}")
        println("단일키 1번 엔티티를 맵에서 조회한 결과 : ${oneMap[oneKeyFirst]}")

        val compositeMap = compositeKeyEntityRepository.findAll().associateWith { it.value }
        val compositeKeyFirst = compositeKeyEntityRepository.findById(CompositeKey(1, "A")).orElseThrow()
        val compositeKeySecond = compositeKeyEntityRepository.findById(CompositeKey(1, "A")).orElseThrow()
        println("복합키 두 엔티티가 동일한가? : ${compositeKeyFirst == compositeKeySecond}")
        println("복합키 1번 엔티티를 맵에서 조회한 결과 : ${compositeMap[compositeKeyFirst]}")
    }
}
