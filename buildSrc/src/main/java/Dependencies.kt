object Apps {
    const val COMPILE_SDK = 29
    const val MIN_SDK = 23
    const val TARGET_SDK = 29
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}

object Versions {
    const val ANDROID_PLUGIN = "4.0.1"
    const val KOTLIN = "1.3.41"
    const val APP_COMPAT = "1.1.0"

    object Test {
        const val JUNIT = "1.1.1"
        const val ESPRESSO = "3.2.0"
    }

    const val RX_JAVA = "2.2.15"
    const val RX_ANDROID = "2.1.1"

    object AndroidX {
        const val MATERIAL = "1.2.0-alpha04"
        const val CONSTRAINT_LAYOUT = "2.0.0-alpha2"
        const val LIFECYCLE_EXTENSION = "2.2.0"
        const val RECYCLERVIEW = "1.1.0"
        const val ROOM = "2.2.5"
        const val DATA_BINDING = "3.1.2"
        const val GRADLE = "4.0.1"
        const val KTX_CORE = "1.2.0"
        const val KTX_FRAGMENT = "1.2.2"
        const val NAVIGATION_FRAGMENT = "2.3.0-alpha02"
        const val NAVIGATION_UI = "2.3.0-alpha02"
        const val SAVED_STATE = "2.2.0"
    }

    object Squareup {
        const val OK_HTTP3 = "4.2.2"
        const val LOGGING_INTERCEPTOR = "4.2.2"
    }

    object Bumptech {
        const val GLIDE = "4.10.0"
        const val GLIDE_BLUR = "4.0.0"
    }

    const val LOTTIE = "3.3.1"
    const val KOIN = "2.1.3"
    const val RETROFIT_VERSION = "2.6.2"
    const val ANKO = "0.10.8"
    const val TRANSFORMATIONLAYOUT = "1.0.3"
    const val SPOTLIGHT = "2.0.1"
}

object TestLibs {
    const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT}.test.junit"
    const val ESPRESSO =
        "androidx.test.espresso:espresso-core:$${Versions.Test.ESPRESSO}.test.espresso"
}

object Libs {
    const val CLASSPATH = "com.android.tools.build:gradle:${Versions.ANDROID_PLUGIN}"
    const val NAVIGATION_ARG =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.NAVIGATION_FRAGMENT}"

    object Androidx {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}.appcompat"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}.androidx.constraintlayout"
        const val MATERIAL =
            "com.google.android.material:material:${Versions.AndroidX.MATERIAL}.androidx.material"
        const val RECYCLERVIEW =
            "androidx.recyclerview:recyclerview:${Versions.AndroidX.RECYCLERVIEW}.androidx.recyclerview"
        const val LIFECYCLE =
            "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.LIFECYCLE_EXTENSION}.androidx.lifecycle_extension"
        const val ROOM_RUNTIME =
            "androidx.room:room-runtime:${Versions.AndroidX.ROOM}.androidx.room"
        const val ROOM_RX_JAVA2 =
            "androidx.room:room-rxjava2:${Versions.AndroidX.ROOM}.androidx.room"
        const val GRADLE =
            "com.android.tools.build:gradle:${Versions.AndroidX.GRADLE}.androidx.gradle"
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.KTX_FRAGMENT}.androidx.navigation_fragment"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION_UI}.androidx.navigation_ui"
        const val SAVED_STATE =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.AndroidX.SAVED_STATE}.androidx.savedstate"
        const val DATA_BINDING =
            "com.android.databinding:compiler:${Versions.AndroidX.DATA_BINDING}.androidx.databinding"
        const val ROOM_COMPILER =
            "androidx.room:room-compiler:${Versions.AndroidX.ROOM}.androidx.room"
        const val KTX = "androidx.core:core-ktx:${Versions.AndroidX.KTX_CORE}.androidx.ktx_core"

        const val KTX_FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.AndroidX.KTX_FRAGMENT}"
    }

    object Kotlin {
        const val SDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}.kotlin_version"

        const val GRADLE_PLUGIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}.kotlin_version"
    }

    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val ADAPTER_RX_JAVA2 =
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT_VERSION}"
    const val RX_JAVA = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA}"
    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
    const val OK_HTTP3 = "com.squareup.okhttp3:okhttp:${Versions.Squareup.OK_HTTP3}"
    const val OK_HTTP_LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${Versions.Squareup.LOGGING_INTERCEPTOR}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Bumptech.GLIDE}"
    const val GLIDE_BLUR =
        "jp.wasabeef:glide-transformations:${Versions.Bumptech.GLIDE_BLUR}"
    const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"
    const val ANKO = "org.jetbrains.anko:anko-commons:${Versions.ANKO}"
    const val TRANSFORMATIONLAYOUT =
        "com.github.skydoves:transformationlayout:${Versions.TRANSFORMATIONLAYOUT}"
    const val SPOTLIGHT = "com.github.takusemba:spotlight:${Versions.SPOTLIGHT}"
}
