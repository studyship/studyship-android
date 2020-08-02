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
//        applicationId = "com.studyship.application"
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
//    implementation fileTree (dir: 'libs', include: ['*.jar'])
    implementation(Libs.Kotlin.SDK)
//    deps . kotlin . sdk
    implementation(Libs.Androidx.APPCOMPAT)

//    deps . androidx . appcompat
    testImplementation(Libs.JUNIT)
//    deps . junit
    implementation(Libs.Androidx.KTX)
//    'androidx.core:core-ktx:1.3.0'
    androidTestImplementation(TestLibs.JUNIT)
//    'androidx.test.ext:junit:1.1.1'
    androidTestImplementation(TestLibs.ESPRESSO)
//    'androidx.test.espresso:espresso-core:3.2.0'


    // koin
    implementation("${Libs.KOIN_VIEWMODEL}")
//    deps . library . koin_viewmodel

    //rxjava
    implementation("${Libs.RX_JAVA}")
//    deps . library . rxjava
    //rxandroid
    implementation("${Libs.RX_ANDROID}")
//    deps . library . rxandroid

    //room
    implementation("${Libs.Androidx.ROOM_RUNTIME}")
//    deps . androidx . room_runtime

    implementation("${Libs.Androidx.ROOM_RX_JAVA2}")
//    deps . androidx . room_rxjava2

    kapt("${Libs.Androidx.ROOM_COMPILER}")
//    deps . kapt . room_compiler

    implementation("${Libs.CONVERTER_GSON}")
//    deps . library . converter_gson

    //multi-module
    implementation(project(":data"))
}
