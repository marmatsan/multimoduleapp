package com.marmatsan.dependencies

open class LibraryDep(
    override val name: String,
    override val group: String,
    val artifacts: List<String>,
    override val version: String
) : Dependency(name, group, version) {

    object AndroidX {
        private const val androidx = "androidx"

        object Core : LibraryDep(
            name = "$androidx.core",
            group = "$androidx.core",
            artifacts = listOf(
                "core-ktx"
            ),
            version = "1.10.1"
        )

        object Navigation : LibraryDep(
            name = "$androidx.navigation",
            group = "$androidx.navigation",
            artifacts = listOf(
                "navigation-compose"
            ),
            version = "2.5.3"
        )

        object Hilt : LibraryDep(
            name = "$androidx.hilt",
            group = "$androidx.hilt",
            artifacts = listOf(
                "navigation-compose"
            ),
            version = "1.0.0"
        )

        object Activity : LibraryDep(
            name = "$androidx.activity",
            group = "$androidx.activity",
            artifacts = listOf(
                "activity-compose"
            ),
            version = "1.6.1"
        )

        object LifeCycle : LibraryDep(
            name = "$androidx.lifecycle",
            group = "$androidx.lifecycle",
            artifacts = listOf(
                "lifecycle-viewmodel-compose"
            ),
            version = "2.6.0"
        )

        object Room {

            private const val group = "$androidx.room"
            private const val version = "2.5.1"

            object RoomBundle : LibraryDep(
                name = group,
                group = group,
                artifacts = listOf(
                    "room-runtime",
                    "room-ktx",
                    "room-paging"
                ),
                version = version
            )

            object Compiler : LibraryDep(
                name = "$group.compiler",
                group = group,
                artifacts = listOf(
                    "room-compiler"
                ),
                version = version
            )

        }

        object Compose {
            private const val compose = "compose"
            private const val composeVersion = "1.3.0"
            private const val composeCompilerVersion = "1.4.3"

            object Material : LibraryDep(
                name = "$androidx.$compose.material",
                group = "$androidx.$compose.material",
                artifacts = listOf(
                    "material"
                ),
                version = composeVersion
            )

            object Material3 : LibraryDep(
                name = "$androidx.$compose.material3",
                group = "$androidx.$compose.material3",
                artifacts = listOf(
                    "material3"
                ),
                version = "1.0.1"
            )

            object Ui : LibraryDep(
                name = "$androidx.$compose.ui",
                group = "$androidx.$compose.ui",
                artifacts = listOf(
                    "ui",
                    "ui-graphics",
                    "ui-tooling-preview"
                ),
                version = composeVersion
            )

            object Runtime : LibraryDep(
                name = "$androidx.$compose.runtime",
                group = "$androidx.$compose.runtime",
                artifacts = listOf(
                    "runtime"
                ),
                version = composeVersion
            )

            object Compiler : LibraryDep(
                name = "$androidx.$compose.compiler",
                group = "$androidx.$compose.compiler",
                artifacts = listOf(
                    "compiler"
                ),
                version = composeCompilerVersion
            )

        }

    }

    object Google {
        private const val google = "com.google"

        object DaggerHilt : LibraryDep(
            name = "$google.daggerHilt",
            group = "$google.dagger",
            artifacts = listOf(
                "hilt-android"
            ),
            version = "2.47"
        )

        object DaggerHiltCompiler : LibraryDep(
            name = "$google.daggerHiltCompiler",
            group = "$google.dagger",
            artifacts = listOf(
                "hilt-android-compiler"
            ),
            version = "2.47"
        )
    }

    object Coil : LibraryDep(
        name = "io.coil-kt",
        group = "io.coil-kt",
        artifacts = listOf(
            "coil-compose"
        ),
        version = "1.3.2"
    )

    object Ktor : LibraryDep(
        name = "io.ktor",
        group = "io.ktor",
        artifacts = listOf(
            "ktor-client-core",
            "ktor-client-android",
            "ktor-client-serialization",
            "ktor-client-content-negotiation",
            "ktor-serialization-kotlinx-json",
            "ktor-client-logging"
        ),
        version = "2.3.1"
    )

}