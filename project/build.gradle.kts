dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation(project(":common"))
    implementation(project(":nms1_17_R1"))
    implementation(project(":nms1_18_R1"))
    implementation(project(":nms1_18_R2"))
    implementation(project(":nms1_19_R1"))
    implementation(project(":nms1_19_R2"))
    implementation(project(":nms1_19_R3"))
    implementation(project(":nms1_20_R1"))
    implementation(project(":nms1_20_R2"))
    implementation(project(":nms1_20_R3"))
    implementation(project(mapOf("path" to ":nms1_20_R4", "configuration" to "reobf")))
    implementation(project(":mojmap_R1"))
    implementation(project(":mojmap1_18_R1"))
    implementation(project(":mojmap1_18_R2"))
    implementation(project(":mojmap1_19_R1"))
    implementation(project(":mojmap1_19_R2"))
    implementation(project(":mojmap1_19_R3"))
    implementation(project(":mojmap1_20_R1"))
    implementation(project(":mojmap1_20_R2"))
    implementation(project(":mojmap1_20_R3"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(17)
}