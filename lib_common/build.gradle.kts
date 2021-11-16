plugins {
    id ("java-library")
    kotlin("jvm")
}

group = "com.github.WangJie0822"

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")

    // 测试
    testImplementation("junit:junit:4.13")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}