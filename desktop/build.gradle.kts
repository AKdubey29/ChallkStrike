import org.apache.tools.ant.taskdefs.Java

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.11.0")
    implementation("com.badlogicgames.gdx:gdx-platform:1.11.0:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-freetype:1.11.0")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.11.0:natives-desktop")
    implementation(project(":core"))

}
sourceSets {
    named("main") {
        resources.srcDirs("../core/assets")  // Add this line
    }
}

tasks.test {
    useJUnitPlatform()
}
