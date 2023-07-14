plugins {
    kotlin("jvm") version "1.9.0"
    application
    `maven-publish`
}

group = "com.arnyminerz.filamagenta.commons"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    api("org.json:json:20230227")
    api("io.ktor:ktor-server-core:2.3.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}
