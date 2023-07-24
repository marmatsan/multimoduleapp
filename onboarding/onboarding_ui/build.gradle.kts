import com.marmatsan.dependencies.Dependencies.Env

dependencies {
    /* Modules */
    implementation(project(Env.Modules.Identifiers.core))
    implementation(project(Env.Modules.Identifiers.onboardingDomain))
}