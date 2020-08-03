plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion(Apps.BUILD_TOOLS_VERSION3)
//    "29.0.3"

    defaultConfig {
        minSdkVersion(Apps.MIN_SDK)
        targetSdkVersion(Apps.TARGET_SDK)
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
    implementation(Libs.Androidx.APPCOMPAT)
    testImplementation(Libs.JUNIT)
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
    androidTestImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO)

    //flexbox
    api(Libs.FLEX_BOX)

    //recyclerview
    implementation(Libs.Androidx.RECYCLERVIEW)

    //data
    implementation(project(":data"))

    //content
    implementation(project(":constant"))
}
