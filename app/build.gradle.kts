plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "sree.ddukk.apiecom"
    compileSdk = 35

    defaultConfig {
        applicationId = "sree.ddukk.apiecom"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation ("androidx.compose.material3:material3:1.0.0")
    implementation ("androidx.compose.material3:material3:1.0.0")
    // Make sure you also have the necessary Compose UI dependencies
    implementation ("androidx.compose.ui:ui:1.3.0")
    implementation ("androidx.compose.material:material-icons-extended:1.3.0")
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.media3.common.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.litert.support.api)
    testImplementation(libs.junit)
    implementation ("io.coil-kt:coil-compose:2.4.0")
    // Jetpack Compose
    implementation ("androidx.compose.foundation:foundation:1.0.0")
    // For LazyVerticalGrid
    implementation ("androidx.compose.foundation:foundation-layout:1.0.0")
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
    implementation("androidx.compose.material:material:1.3.0")

    // Your other dependencies
    implementation ("androidx.compose.material3:material3:1.0.0")
    implementation ("androidx.compose.ui:ui:1.3.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.0")

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}