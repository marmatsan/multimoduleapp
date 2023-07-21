package com.marmatsan.compose

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class Compose : Plugin<Project> {
    override fun apply(project: Project) {

        val androidExtension = project.extensions.getByName("android") as ApplicationExtension

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