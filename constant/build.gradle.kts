
plugins {
    id("kotlin")
    `java-library`
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.SDK)
}

//sourceCompatibility = "7"
//targetCompatibility = "7"
