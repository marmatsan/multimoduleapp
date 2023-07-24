import com.marmatsan.dependencies.Dependencies.Env

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
    // App
    Env.Modules.Identifiers.app,
    // Core
    Env.Modules.Identifiers.core,
    // Onboarding
    *arrayOf(
        Env.Modules.Identifiers.onboardingDomain,
        Env.Modules.Identifiers.onboardingUi
    ),
    // Tracker
    *arrayOf(
        Env.Modules.Identifiers.trackerData,
        Env.Modules.Identifiers.trackerDomain,
        Env.Modules.Identifiers.trackerUi
    )
)

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}