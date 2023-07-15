package com.example.multiserver.exception

class BadRequestException(override val message: String) : RuntimeException(message)