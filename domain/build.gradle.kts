plugins {
    id("kotlin")
    `java-library`
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation(Libs.Kotlin.SDK)

    //rxjava
    implementation(Libs.RX_JAVA)
    //rxandroid
    implementation(Libs.RX_ANDROID)

    //koin
    implementation(Libs.KOIN_VIEWMODEL)
}
