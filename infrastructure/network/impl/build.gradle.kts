plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }

    dependencies {
        implementation(project(":infrastructure:network:api"))

        implementation(platform(libs.okHttp.bom))

        implementation(libs.okHttp.core)
        implementation(libs.okHttp.loggingInterceptor)
        implementation(libs.retrofit)
        implementation(libs.retrofit.converter.gson)
    }
}
