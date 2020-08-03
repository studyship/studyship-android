
plugins {
    id("kotlin")
    `java-library`
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
//    deps.kotlin.sdk

    //rxjava
    implementation(Libs.RX_JAVA)
//    deps.library.rxjava
    //rxandroid
    implementation(Libs.RX_ANDROID)
//    deps.library.rxandroid

    //koin
    implementation(Libs.KOIN_VIEWMODEL)
//    deps.library.koin_viewmodel

    implementation(project(":domain"))
}