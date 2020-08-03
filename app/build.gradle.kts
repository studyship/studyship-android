plugins {
    id("com.android.application")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion(Apps.BUILD_TOOL_VERSION)

    defaultConfig {
        applicationId = Apps.APPLICATION_ID
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
    testImplementation(Libs.JUNIT)
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
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

//            //room
//            implementation deps . androidx . room_runtime
//            kapt deps . kapt . room_compiler
//            implementation deps . androidx . room_rxjava2


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
    isExperimental = true
//    configure(delegateClosureOf<AndroidExtensionsExtension> {
//        isExperimental = true
//    })
}