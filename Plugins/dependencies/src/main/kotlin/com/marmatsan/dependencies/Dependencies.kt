package com.marmatsan.dependencies

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.initialization.resolve.DependencyResolutionManagement

class Dependencies : Plugin<Settings> {

    override fun apply(settings: Settings) {
        settings.dependencyResolutionManagement {
            versionCatalogsBuilder(
                catalogs = listOf(
                    Libraries,
                    Plugins
                )
            )
        }
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

    private fun DependencyResolutionManagement.versionCatalogsBuilder(catalogs: List<Catalog>) {
        versionCatalogs {
            catalogs.forEach { catalog ->
                create(catalog.name) {
                    catalog.dependencies.forEach { dependency ->
                        when (dependency) {
                            is PluginDep -> {
                                plugin(dependency.name, dependency.group).version(dependency.version)
                            }

                            is LibraryDep -> {
                                if (dependency.artifacts.size == 1) {
                                    val libraryDep =
                                        "${dependency.group}:${dependency.artifacts[0]}:${dependency.version}"
                                    library(
                                        dependency.name,
                                        libraryDep
                                    )
                                } else {
                                    version(
                                        dependency.name,
                                        dependency.version
                                    )
                                    dependency.artifacts.forEach { artifact ->
                                        library(
                                            artifact, // TODO: It can create duplicates. Change alias and artifact to be different
                                            dependency.group,
                                            artifact
                                        ).versionRef(dependency.name)
                                    }
                                    bundle(
                                        dependency.name,
                                        dependency.artifacts
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}