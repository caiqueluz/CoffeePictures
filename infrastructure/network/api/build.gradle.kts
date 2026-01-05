plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    dependencies {
        implementation(platform(libs.okHttp.bom))

        implementation(libs.okHttp.core)
        implementation(libs.retrofit)
    }
}
