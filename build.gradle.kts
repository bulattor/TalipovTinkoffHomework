plugins {
    kotlin("jvm") version "1.5.10"
}

group = "ru.tinkoff"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("junit:junit:4.13.2")
    implementation("io.mockk:mockk-dsl:1.12.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testImplementation("io.mockk:mockk:1.12.3")
}

tasks{
    test{
        useJUnitPlatform()
    }
}