package com.example.multiserver.model.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity


@Embeddable
data class CompositeKey(
        val id1: Long = 0L,
        val id2: String
) : Serializable

@Entity
class CompositeKeyEntity(
        @EmbeddedId
        val id: CompositeKey,
        val value: String,
) {
        override fun hashCode(): Int {
                return id.id1.hashCode() + id.id2.hashCode()
        }

        override fun equals(other: Any?): Boolean {
                return other is CompositeKeyEntity && id.id1 == other.id.id1 && id.id2 == other.id.id2
        }
}

interface CompositeKeyEntityRepository : JpaRepository<CompositeKeyEntity, CompositeKey> {

}