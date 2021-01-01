// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Libs.Androidx.GRADLE)
        classpath(Libs.Kotlin.GRADLE_PLUGIN)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath(Libs.CLASSPATH)
        classpath(Libs.NAVIGATION_ARG)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    val jitPackUrl = "https://jitpack.io"
    repositories {
        google()
        jcenter()
        maven(jitPackUrl)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
