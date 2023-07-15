
plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("kapt")
}

repositories {
    mavenCentral()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.springframework", module = "spring-boot-starter-tomcat")
    }
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.swagger:swagger-annotations:1.5.20")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("io.springfox:springfox-swagger-ui")
    implementation("io.springfox:springfox-boot-starter")

    implementation("mysql:mysql-connector-java")
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
}

tasks.test {
    useJUnitPlatform()
}