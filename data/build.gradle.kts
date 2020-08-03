plugins {
    `java-library`
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)

    //rxjava
    implementation(Libs.RX_JAVA)

    //rxandroid
    implementation(Libs.RX_ANDROID)

    //koin
    implementation(Libs.KOIN_VIEWMODEL)

    implementation(project(":domain"))
}