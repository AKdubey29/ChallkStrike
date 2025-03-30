
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

rootProject.name = "TeacherShooter"
include("core")
include("desktop")