package com.marmatsan.dependencies

open class PluginDep(
    override val name: String,
    override val group: String,
    override val version: String
) : Dependency(name, group, version) {

    object Android {
        private const val group = "com.android"
        private const val version = "7.4.1"

        object Application : PluginDep(
            name = "$group.application",
            group = "$group.application",
            version = version
        )

        object Library : PluginDep(
            name = "$group.library",
            group = "$group.library",
            version = version
        )
    }

    object JetBrains {
        private const val group = "org.jetbrains.kotlin"
        private const val version = "1.9.0"

        object Android : PluginDep(
            name = "$group.android",
            group = "$group.android",
            version = version
        )

        object Jvm : PluginDep(
            name = "$group.jvm",
            group = "$group.jvm",
            version = version
        )

        object Kapt : PluginDep(
            name = "$group.kapt",
            group = "$group.kapt",
            version = version
        )

        object Parcelize : PluginDep(
            name = "$group.plugin.parcelize",
            group = "$group.plugin.parcelize",
            version = version
        )
    }

    object Google {
        private const val group = "com.google"

        object DaggerHilt : PluginDep(
            name = "$group.dagger.hilt.android",
            group = "$group.dagger.hilt.android",
            version = "2.47"
        )

        object Ksp : PluginDep(
            name = "$group.devtools.ksp",
            group = "$group.devtools.ksp",
            version = "1.8.22-1.0.11"
        )
    }

}