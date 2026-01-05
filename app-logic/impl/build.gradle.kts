plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.coffeepictures.applogic.impl"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":app-logic:api"))
    implementation(project(":infrastructure:database:api"))
    implementation(project(":infrastructure:network:api"))

    implementation(platform(libs.okHttp.bom))
    implementation(platform(libs.koin.bom))

    implementation(libs.koin.core)
    implementation(libs.okHttp.core)
    implementation(libs.okHttp.loggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}
