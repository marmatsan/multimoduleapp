import com.marmatsan.dependencies.Dependencies.Env

dependencies {
    /* Modules */
    implementation(project(Env.Modules.Identifiers.coreUi))
    implementation(project(Env.Modules.Identifiers.coreDomain))
    implementation(project(Env.Modules.Identifiers.trackerDomain))

    /* Libraries */
    // Coil
    implementation(libs.io.coil.kt)
}