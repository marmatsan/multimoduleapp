import com.marmatsan.dependencies.Dependencies.Env

android {

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}

dependencies {

    /* Modules */
    // Core
    implementation(project(Env.Modules.Identifiers.core))
    implementation(project(Env.Modules.Identifiers.coreUi))
    // Onboarding
    implementation(project(Env.Modules.Identifiers.onboardingDomain))
    implementation(project(Env.Modules.Identifiers.onboardingUi))
    //Tracker
    implementation(project(Env.Modules.Identifiers.trackerData))
    implementation(project(Env.Modules.Identifiers.trackerDomain))
    implementation(project(Env.Modules.Identifiers.trackerUi))

    /* Libraries */
    // Core
    implementation(libs.androidx.core)
    // Lifecycle
    implementation(libs.bundles.androidx.lifecycle)
    // Activity Compose
    implementation(libs.androidx.activity)

}
