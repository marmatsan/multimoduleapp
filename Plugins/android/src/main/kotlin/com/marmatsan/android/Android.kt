package com.marmatsan.android

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

class Android : Plugin<Project> {
    override fun apply(project: Project) {

        project.plugins.apply("org.jetbrains.kotlin.android")
        project.plugins.apply("com.google.dagger.hilt.android")
        project.plugins.apply("org.jetbrains.kotlin.kapt")

        val androidExtension = project.extensions.getByName("android") as BaseExtension

        androidExtension.apply {
            namespace = "com.marmatsan.${project.name}"
            compileSdkVersion(apiLevel = 33)

            defaultConfig {

                val majorVersion = 1
                val minorVersion = 0
                val bugfixVersion = 0

                minSdk = 21
                targetSdk = 33
                versionCode = majorVersion * 1000 + minorVersion * 100 + bugfixVersion
                versionName = "${majorVersion}.${minorVersion}.$bugfixVersion"

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }

                project.tasks.withType<KotlinJvmCompile>().configureEach {
                    compilerOptions.languageVersion.set(KotlinVersion.KOTLIN_1_8)
                }

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

        }

        project.dependencies {
            add("implementation", "com.google.dagger:hilt-android:2.47")
            add("annotationProcessor", "com.google.dagger:hilt-android-compiler:2.47")
        }

    }
}