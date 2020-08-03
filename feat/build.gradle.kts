//apply plugin: 'com.android.library'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-android-extensions'
//apply plugin: 'kotlin-kapt'
//apply from: '/Users/taeseongyun/studyship-android/dependency.gradle'

plugins {
    id("com.android.library")
    kotlin("kapt")
    kotlin("android")
    kotlin("android.extensions")
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile ('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
//            deps . kotlin . sdk
    implementation(Libs.Androidx.APPCOMPAT)
//            deps . androidx . appcompat
    testImplementation(Libs.JUNIT)
//            deps . junit
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
//            deps . androidx . constraintlayout
    //
    androidTestImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO)
//            'androidx.test.espresso:espresso-core:3.2.0'

    //flexbox
    api(Libs.FLEX_BOX)
//    'com.google.android:flexbox:2.0.1'

    //recyclerview
    implementation(Libs.Androidx.RECYCLERVIEW)
//    deps . androidx . recyclerview

    //data
    implementation(project(":data"))

    //content
    implementation(project(":constant"))
}
