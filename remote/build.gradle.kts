plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Apps.COMPILE_SDK)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(16)
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

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
    implementation(Libs.Androidx.APPCOMPAT)
    testImplementation(Libs.JUNIT)
    androidTestImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.ESPRESSO)

    implementation(project(":data"))
}
