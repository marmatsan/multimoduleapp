import com.marmatsan.dependencies.Dependencies.Env

plugins {
    `version-catalog`
    alias(plugins.plugins.com.android.application) apply false
    alias(plugins.plugins.com.android.library) apply false
    alias(plugins.plugins.org.jetbrains.kotlin.android) apply false
    alias(plugins.plugins.com.google.dagger.hilt.android) apply false
    alias(plugins.plugins.org.jetbrains.kotlin.kapt) apply false

    /* Custom project plugins */
    id("com.marmatsan.android") apply false
    id("com.marmatsan.compose") apply false
}

subprojects {
    if (project.name == Env.Modules.Names.app) {
        apply(plugin = "com.android.application")
        apply(plugin = "com.marmatsan.android")
        apply(plugin = "com.marmatsan.compose")
    } else {
        apply(plugin = "com.android.library")
        apply(plugin = "com.marmatsan.android")
        //Apply only gradle plugin when the module uses compose: apply(plugin = "com.marmatsan.compose")
    }
}

