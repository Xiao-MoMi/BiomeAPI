plugins {
    id("io.papermc.paperweight.userdev") version "1.7.0"
}

dependencies {
    compileOnly(project(":common"))
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}