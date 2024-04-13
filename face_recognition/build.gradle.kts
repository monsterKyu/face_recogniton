plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.kookie.face_recognition"
    compileSdk = 34

    defaultConfig {
        minSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation("org.testng:testng:6.9.6")

    val camerax_version = "1.2.1"

    implementation ("androidx.camera:camera-core:${camerax_version}")
    implementation ("androidx.camera:camera-camera2:${camerax_version}")
    implementation ("androidx.camera:camera-lifecycle:${camerax_version}")

    implementation ("androidx.camera:camera-view:${camerax_version}")
    implementation ("androidx.camera:camera-extensions:${camerax_version}")

    implementation("com.google.mlkit:face-detection:16.1.6")

}