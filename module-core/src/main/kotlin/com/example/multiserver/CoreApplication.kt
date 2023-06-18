package com.example.multiserver

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(
    scanBasePackageClasses = [CoreApplication::class]
)
class CoreApplication