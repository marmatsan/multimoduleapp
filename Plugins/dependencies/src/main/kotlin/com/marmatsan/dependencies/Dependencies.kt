package com.marmatsan.dependencies

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class Dependencies : Plugin<Settings> {

    override fun apply(target: Settings) {
        // no-op
    }

    object Libraries : Catalog(
        name = "libs",
        dependencies = listOf(
            LibraryDep.AndroidX.Core,
            LibraryDep.AndroidX.Navigation,
            LibraryDep.AndroidX.Hilt,
            LibraryDep.AndroidX.Activity,
            LibraryDep.AndroidX.LifeCycle,
            LibraryDep.AndroidX.Compose.Material,
            LibraryDep.AndroidX.Compose.Material3,
            LibraryDep.AndroidX.Compose.Compiler,
            LibraryDep.AndroidX.Compose.Runtime,
            LibraryDep.AndroidX.Compose.Ui,
            LibraryDep.AndroidX.Room.RoomBundle,
            LibraryDep.AndroidX.Room.Compiler,
            LibraryDep.Coil,
            LibraryDep.Google.DaggerHilt,
            LibraryDep.Google.DaggerHiltCompiler,
            LibraryDep.Ktor
        )
    )

    object Plugins : Catalog(
        name = "plugins",
        dependencies = listOf(
            PluginDep.Android.Application,
            PluginDep.Android.Library,
            PluginDep.JetBrains.Android,
            PluginDep.JetBrains.Jvm,
            PluginDep.JetBrains.Kapt,
            PluginDep.JetBrains.Parcelize,
            PluginDep.Google.DaggerHilt,
            PluginDep.Google.Ksp
        )
    )

}