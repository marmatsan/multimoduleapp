plugins {
    id("com.marmatsan.android") apply false
    id("com.android.application") version "7.4.1" apply false
    id("com.android.library") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
}

subprojects {
    if (project.name == "app"){
        apply(plugin = "com.android.application")
        apply(plugin = "com.marmatsan.android")
    }
}