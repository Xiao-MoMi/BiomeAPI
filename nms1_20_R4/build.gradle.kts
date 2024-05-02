plugins {
    id("io.papermc.paperweight.userdev") version "1.7.0"
}

dependencies {
    compileOnly(project(":common"))
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}