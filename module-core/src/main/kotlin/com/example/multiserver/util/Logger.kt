package com.example.multiserver.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Logger {
    val logger: Logger get() = LoggerFactory.getLogger(this::class.java)
}