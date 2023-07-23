pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("./Plugins")
}

plugins {
    id("com.marmatsan.dependencies") apply true
}

rootProject.name = "MultiLayerApp"
include(
    ":app",
    ":core"
)

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}