package com.example.multiserver.util

object TimeUtil {
    fun measureTime(block: () -> Unit): String {
        val startTime = System.currentTimeMillis()
        block()
        val endTime = System.currentTimeMillis()
        val executionTime = endTime - startTime
        return "$executionTime ms (${executionTime / 1000} s)"
    }
}
