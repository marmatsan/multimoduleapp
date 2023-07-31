import com.marmatsan.dependencies.Dependencies

dependencies {
    /* Modules */
    implementation(project(Dependencies.Env.Modules.Identifiers.coreDomain))

    /* Libraries */
    implementation(libs.androidx.datastore)
}