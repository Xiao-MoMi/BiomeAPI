dependencies {
    compileOnly(project(":common"))
    compileOnly(files("libs/1.20.6.jar"))
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT") // 1.20.6 has bugs
    compileOnly(files("$rootDir/libs/datafixerupper-5.0.28.jar"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}