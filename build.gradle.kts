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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.arnyminerz.filamagenta"
            artifactId = "commons"
            version = "1.0.0"

            from(components["java"])

            pom {
                name.set("Filà Magenta Commons")
                description.set("The main library for all Kotlin projects. Includes all common functions and classes for client and server.")
                url.set("https://github.com/FilaMagenta/Commons")
                developers {
                    developer {
                        id.set("arnyminerz")
                        name.set("Arnau Mora")
                        email.set("arnyminerz@proton.me")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/FilaMagenta/Commons.git")
                    developerConnection.set("scm:git:ssh://github.com/FilaMagenta/Commons.git")
                    url.set("http://github.com/FilaMagenta/Commons")
                }
            }
        }
    }
}
