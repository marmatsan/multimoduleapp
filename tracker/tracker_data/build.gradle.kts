import com.marmatsan.dependencies.Dependencies.Env

dependencies {
    /* Modules */
    implementation(project(Env.Modules.Identifiers.core))
    implementation(project(Env.Modules.Identifiers.trackerDomain))

    /* Libraries */
    // Ktor
    implementation(libs.bundles.io.ktor)
    // Room
    implementation(libs.bundles.androidx.room)
}