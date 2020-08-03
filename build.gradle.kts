// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
//    apply from: 'dependency.gradle'

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Libs.Androidx.GRADLE)
//        deps.androidx.gradle
        classpath(Libs.Kotlin.GRADLE_PLUGIN)
//        deps.kotlin.gradle_plugin
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath(Libs.CLASSPATH)
//        deps.classpath
        classpath(Libs.NAVIGATION_ARG)
//        deps.navigation_arg

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
