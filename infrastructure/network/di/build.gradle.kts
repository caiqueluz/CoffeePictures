plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    dependencies {
        implementation(project(":infrastructure:network:api"))
        implementation(project(":infrastructure:network:impl"))

        implementation(platform(libs.koin.bom))
        implementation(libs.koin.core)
    }
}
