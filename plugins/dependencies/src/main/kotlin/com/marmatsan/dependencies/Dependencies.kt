package com.marmatsan.dependencies

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.initialization.resolve.DependencyResolutionManagement

class Dependencies : Plugin<Settings> {

    companion object Env {

        object Modules {

            object Names {
                // app
                const val app = "app"

                // core
                const val core = "core"
                const val coreUi = "core_ui"

                // onboarding
                const val onboarding = "onboarding"
                const val onboardingDomain = "${onboarding}_domain"
                const val onboardingUi = "${onboarding}_ui"

                // tracker
                const val tracker = "tracker"
                const val trackerData = "${tracker}_data"
                const val trackerDomain = "${tracker}_domain"
                const val trackerUi = "${tracker}_ui"
            }

            object Identifiers {
                // app
                const val app = ":${Names.app}"

                // core
                const val core = ":${Names.core}"
                const val coreUi = ":${Names.coreUi}"

                // onboarding
                const val onboardingDomain = ":${Names.onboarding}:${Names.onboardingDomain}"
                const val onboardingUi = ":${Names.onboarding}:${Names.onboardingUi}"

                // tracker
                const val trackerData = ":${Names.tracker}:${Names.trackerData}"
                const val trackerDomain = ":${Names.tracker}:${Names.trackerDomain}"
                const val trackerUi = ":${Names.tracker}:${Names.trackerUi}"
            }

        }

    }

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
                                plugin(
                                    dependency.name,
                                    dependency.group
                                ).version(dependency.version)
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