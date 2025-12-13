plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.coffeepictures.infrastructure.database.di"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":infrastructure:database:api"))
    implementation(project(":infrastructure:database:impl"))

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.room.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}
