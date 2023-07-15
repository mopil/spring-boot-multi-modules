package com.example.multiserver.util

object EnvironmentHelper {
    private val activeProfile = System.getProperty("spring.profiles.active")
    fun isTest(): Boolean = containsProfile("test")
    fun isLive(): Boolean = containsProfile("live")

    private fun containsProfile(profile: String): Boolean =
        activeProfile == profile
}
