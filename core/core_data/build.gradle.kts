import com.marmatsan.dependencies.Dependencies

plugins {
    alias(plugins.plugins.org.jetbrains.kotlin.plugin.serialization) apply true
}

dependencies {
    /* Modules */
    implementation(project(Dependencies.Env.Modules.Identifiers.coreDomain))

    /* Libraries */
    // DataStore
    implementation(libs.androidx.datastore)
    // Kotlin Serialization
    implementation(libs.org.jetbrains.kotlinx.serialization)
}