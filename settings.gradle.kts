import com.marmatsan.dependencies.Catalog
import com.marmatsan.dependencies.Dependencies
import com.marmatsan.dependencies.LibraryDep
import com.marmatsan.dependencies.PluginDep

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("./Plugins")
    plugins {
        id("com.marmatsan.dependencies")
    }
}

plugins {
    id("com.marmatsan.dependencies")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MultiLayerApp"
include(
    ":app"
)

fun DependencyResolutionManagement.versionCatalogsBuilder(
    catalogs: List<Catalog>
) {
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
                                val libraryDep = "${dependency.group}:${dependency.artifacts[0]}:${dependency.version}"
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

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogsBuilder(
        catalogs = listOf(
            Dependencies.Libraries,
            Dependencies.Plugins
        )
    )
}