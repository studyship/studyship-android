//apply plugin: ''
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-android-extensions'
//apply plugin: 'kotlin-kapt'
//apply plugin: 'androidx.navigation.safeargs.kotlin'
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
//    versions . compile_Sdk_Version
//    buildToolsVersion(Apps.) versions.build_Tools_Version

    defaultConfig {
//        applicationId "com.studyship.application"
        minSdkVersion(Apps.MIN_SDK)
//        versions.min_sdk_version
        targetSdkVersion(Apps.TARGET_SDK)
//        versions.target_sdk_version
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME
        multiDexEnabled = true
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
        resConfigs("en")
        ndk {
            abiFilters("armeabi-v7a", "x86", "arm64-v8a", "x86_64")
        }
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    ndkVersion = "21.3.6528147"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
//    deps . kotlin . sdk
    implementation(Libs.Androidx.APPCOMPAT)
    //deps . androidx . appcompat
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
//    deps . androidx . constraintlayout
    implementation(Libs.Androidx.APPCOMPAT)
//    'androidx.appcompat:appcompat:1.1.0'
//    implementation(Libs.) 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation(Libs.JUNIT)
//    deps . junit
    androidTestImplementation(TestLibs.JUNIT)
//    deps . test . junit
    androidTestImplementation(TestLibs.ESPRESSO)
//    deps . test . espresso


    //retrofit
    implementation(Libs.RETROFIT)
//    deps . library . retrofit
    implementation(Libs.ADAPTER_RX_JAVA2)
//    deps . library . adapter_rxjava2
    implementation(Libs.CONVERTER_GSON)
    //deps . library . converter_gson

    //rxjava
    implementation(Libs.RX_JAVA)
//    deps . library . rxjava
    //rxandroid
    implementation(Libs.RX_ANDROID)
//    deps . library . rxandroid

    //okhttp
    implementation(Libs.OK_HTTP3)
//    deps . library . okhttp3
    implementation(Libs.OK_HTTP_LOGGING)
//    deps.library.okhttp_logging

    implementation(Libs.GLIDE)
//    deps . library . glide
    implementation(Libs.GLIDE_BLUR)
//    deps . library . glide_blur

    //androidx
    implementation(Libs.Androidx.LIFECYCLE)
//    deps . androidx . lifecycle
    implementation(Libs.Androidx.RECYCLERVIEW)
//    deps . androidx . recyclerview
    implementation(Libs.Androidx.MATERIAL)
//    deps . androidx . material

    //lottie
    implementation(Libs.LOTTIE)
//    deps . library . lottie

    //databinding
    kapt(Libs.Androidx.DATA_BINDING)
//    deps . kapt . databinding

    //room
    implementation(Libs.Androidx.ROOM_RUNTIME)
//    deps . androidx . room_runtime
    kapt(Libs.Androidx.ROOM_COMPILER)
//    deps . kapt . room_compiler
    implementation(Libs.Androidx.ROOM_RX_JAVA2)
//    deps . androidx . room_rxjava2


    //koin
    // Koin AndroidX ViewModel features
    implementation(Libs.KOIN_VIEWMODEL)
//    deps . library . koin_viewmodel

    //ktx
    implementation(Libs.Androidx.KTX_FRAGMENT)
//    deps . ktx . fragment
    implementation(Libs.Androidx.KTX)
//    deps . kotlin . ktx
    implementation(Libs.Androidx.NAVIGATION_FRAGMENT)
//    deps . androidx . navigation_fragment
    implementation(Libs.Androidx.NAVIGATION_UI)
//    deps . androidx . navigation_ui
    implementation(Libs.Androidx.SAVED_STATE)
//    deps . androidx . savedstate

    //transformationlayout
    implementation(Libs.TRANSFORMATIONLAYOUT)
//    deps . library . transformationlayout

    //Spotlight
    implementation(Libs.SPOTLIGHT)
//    deps . library . spotlight


    //multi-module
    implementation(project(":feat"))
    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":local"))
    implementation(project(":remote"))
    implementation(project(":constant"))
}

androidExtensions {
    //리사이클러 뷰 find 캐싱
    // 실험실 기능을 활성화합니다
    isExperimental = true
//    configure(delegateClosureOf<AndroidExtensionsExtension> {
}