plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
    application
}

group = "ru.wilddisk.tradeintrade"
version = "0.0.1"
application {
//    mainClass.set("ru.wilddisk.tradeintrade.ApplicationKt")
    mainClass.set("io.ktor.server.netty.EngineMain")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

//server
dependencies {
    implementation(projects.shared)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.swagger)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.default.headers)
}

//serialization - пока хз почему отдельно нужно добавить в зависимости сервера, а не только в shared 🤷
dependencies {
    implementation(libs.ktor.serialization.kotlinx.json)
}

//test
dependencies {
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}