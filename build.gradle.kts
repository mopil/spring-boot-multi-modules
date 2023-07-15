import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21" apply false
	kotlin("plugin.jpa") version "1.6.21" apply false
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "java")

	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring") //all-open
	apply(plugin = "kotlin-jpa")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

		testImplementation("org.springframework.boot:spring-boot-starter-test")

		implementation("com.fasterxml.jackson.core:jackson-annotations")
		implementation("com.fasterxml.jackson.core:jackson-core")
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

		api("org.springframework.boot:spring-boot-starter-validation")
		implementation("com.github.maricn:logback-slack-appender:1.6.1")
	}

	dependencyManagement {
		imports {
			mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
		}

		dependencies {
			dependency("net.logstash.logback:logstash-logback-encoder:6.6")
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}
}

project(":module-core") {
	val jar: Jar by tasks
	val bootJar: BootJar by tasks

	bootJar.enabled = false
	jar.enabled = true
}