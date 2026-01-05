plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    dependencies {
        implementation(project(":infrastructure:network:api"))

        implementation(platform(libs.okHttp.bom))
        implementation(platform(libs.koin.bom))

        implementation(libs.koin.core)
        implementation(libs.okHttp.core)
        implementation(libs.okHttp.loggingInterceptor)
        implementation(libs.retrofit)
        implementation(libs.retrofit.converter.gson)
    }
}
