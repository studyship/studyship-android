plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(17)
//        17
        targetSdkVersion(Apps.TARGET_SDK)
//        29
        versionCode = Apps.VERSION_CODE
//        1
        versionName = Apps.VERSION_NAME
//        "1.0"

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
    //
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
