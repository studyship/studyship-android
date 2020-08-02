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
//    implementation fileTree (dir: 'libs', include: ['*.jar'])
    implementation(Libs.Kotlin.SDK)
//    deps . kotlin . sdk
    implementation(Libs.Androidx.APPCOMPAT)
//    deps . androidx . appcompat
    testImplementation(Libs.JUNIT)
//    deps . junit
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
//    deps . androidx . constraintlayout
    //
    androidTestImplementation(TestLibs.JUNIT)
//    'androidx.test.ext:junit:1.1.1'
    androidTestImplementation(TestLibs.ESPRESSO)
//    'androidx.test.espresso:espresso-core:3.2.0'

    //flexbox
    api(Libs.FLEX_BOX)

    //recyclerview
    implementation(Libs.Androidx.RECYCLERVIEW)
//    deps . androidx . recyclerview

    //data
    implementation(project(":data"))

    //content
    implementation(project(":constant"))
}
