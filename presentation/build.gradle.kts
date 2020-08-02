//apply plugin : 'com.android.library'
//apply plugin : 'kotlin-android'
//apply plugin : 'kotlin-android-extensions'

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
//    29
    buildToolsVersion("29.0.3")
//    "29.0.3"

    defaultConfig {
//        applicationId "com.studyship.application"
        minSdkVersion(16)
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

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    implementation fileTree (dir: 'libs', include: ['*.jar'])

    implementation("${Libs.Kotlin.SDK}")
//    implementation deps . kotlin . sdk
    implementation("${Libs.Androidx.APPCOMPAT}")
//    deps . androidx . appcompat
    testImplementation("${Libs.JUNIT}")
//    deps . junit
    androidTestImplementation("${TestLibs.JUNIT}")
//    'androidx.test.ext:junit:1.1.1'
    androidTestImplementation("${TestLibs.ESPRESSO}")
//    'androidx.test.espresso:espresso-core:3.2.0'

    //koin
    implementation("${Libs.KOIN_VIEWMODEL}")
//    deps . library . koin_viewmodel

    //rxjava
    implementation("${Libs.RX_JAVA}")
//    deps . library . rxjava
    //rxandroid
    implementation("${Libs.RX_ANDROID}")
//    deps . library . rxandroid

    implementation(project(":domain"))
}
