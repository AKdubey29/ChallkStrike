val gdxVersion="1.12.0"



plugins {
    id("java-library")
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:1.11.0")

        implementation("com.badlogicgames.gdx:gdx-freetype:1.11.0")
    implementation("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")// other dependencies...
}
