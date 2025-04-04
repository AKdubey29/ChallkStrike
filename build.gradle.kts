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
    implementation ("com.badlogicgames.gdx:gdx:1.12.0")
    implementation ("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.12.0")
    implementation ("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-desktop")
    implementation (project(":core") ) // Ensure your "core" module is linked

}

tasks.test {
    useJUnitPlatform()
}