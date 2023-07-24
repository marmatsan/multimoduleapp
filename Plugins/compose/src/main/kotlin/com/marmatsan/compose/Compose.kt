package com.marmatsan.compose

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class Compose : Plugin<Project> {
    override fun apply(project: Project) {

        project.afterEvaluate {

            val androidExtension = when {
                project.plugins.hasPlugin(AppPlugin::class.java) -> {
                    project.extensions.getByName("android") as ApplicationExtension
                }

                else -> project.extensions.getByName("android") as LibraryExtension
            }

            androidExtension.apply {

                defaultConfig {
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.4.8"
                }

            }
        }

    }
}