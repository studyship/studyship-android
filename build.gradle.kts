// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("${Libs.Androidx.GRADLE}")
        classpath ("${Libs.Kotlin.GRADLE_PLUGIN}")
        // NOTE: Do not place your application dependencies here; they belong
        classpath ("${Libs.CLASSPATH}")
        classpath ("${Libs.NAVIGATION_ARG}")

        // NOTE: Do not place your application dependencies here; they belong
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class) {
    delete (rootProject.buildDir)
}
