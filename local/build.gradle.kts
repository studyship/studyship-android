//apply plugin: 'com.android.library'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-kapt'
//apply plugin: 'kotlin-android-extensions'

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
//    29
    buildToolsVersion("29.0.3")
//    "29.0.3"

    defaultConfig {
        minSdkVersion(21)
//        versions.min_sdk_version
        targetSdkVersion(Apps.TARGET_SDK)
//        versions.target_sdk_version
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME
//        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
//        resConfigs("en")
//        ndk {
//            abiFilters("armeabi-v7a", "x86", "arm64-v8a", "x86_64")
//        }
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
    implementation(Libs.Androidx.APPCOMPAT)

    testImplementation(Libs.JUNIT)
    implementation(Libs.Androidx.KTX)
    androidTestImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO)


    // koin
    implementation(Libs.KOIN_VIEWMODEL)

    //rxjava
    implementation(Libs.RX_JAVA)

    //rxandroid
    implementation(Libs.RX_ANDROID)

    //room
    implementation(Libs.Androidx.ROOM_RUNTIME)

    implementation(Libs.Androidx.ROOM_RX_JAVA2)

    kapt(Libs.Androidx.ROOM_COMPILER)

    implementation(Libs.CONVERTER_GSON)

    //multi-module
    implementation(project(":data"))
}
