plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion(Apps.BUILD_TOOL_VERSION)

    defaultConfig {
        applicationId = "com.studyship.application"
        minSdkVersion(Apps.MIN_SDK)
        targetSdkVersion(Apps.TARGET_SDK)
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompatibility
        targetCompatibility = Apps.targetCompatibility
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
    implementation(Libs.Androidx.APPCOMPAT)
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
    implementation(Libs.Androidx.APPCOMPAT)
    testImplementation(Libs.JUNIT)
    androidTestImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO)


    //retrofit
    implementation(Libs.RETROFIT)
    implementation(Libs.ADAPTER_RX_JAVA2)
    implementation(Libs.CONVERTER_GSON)

    //rxjava
    implementation(Libs.RX_JAVA)
    //rxandroid
    implementation(Libs.RX_ANDROID)

    //okhttp
    implementation(Libs.OK_HTTP3)
    implementation(Libs.OK_HTTP_LOGGING)

    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_BLUR)

    //androidx
    implementation(Libs.Androidx.LIFECYCLE)
    implementation(Libs.Androidx.RECYCLERVIEW)
    implementation(Libs.Androidx.MATERIAL)

    //lottie
    implementation(Libs.LOTTIE)

    //databinding
    kapt(Libs.Androidx.DATA_BINDING)

    //room
    implementation(Libs.Androidx.ROOM_RUNTIME)
    kapt(Libs.Androidx.ROOM_COMPILER)
    implementation(Libs.Androidx.ROOM_RX_JAVA2)


    //koin
    implementation(Libs.KOIN_VIEWMODEL)

    //ktx
    implementation(Libs.Androidx.KTX_FRAGMENT)
    implementation(Libs.Androidx.KTX)
    implementation(Libs.Androidx.NAVIGATION_FRAGMENT)
    implementation(Libs.Androidx.NAVIGATION_UI)
    implementation(Libs.Androidx.SAVED_STATE)

    //transformationlayout
    implementation(Libs.TRANSFORMATIONLAYOUT)

    //Spotlight
    implementation(Libs.SPOTLIGHT)


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
}