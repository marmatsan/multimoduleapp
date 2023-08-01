package com.marmatsan.multimoduleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marmatsan.core_domain.navigation.Route
import com.marmatsan.multimoduleapp.navigation.navigate
import com.marmatsan.multimoduleapp.ui.theme.MultiLayerAppTheme
import com.marmatsan.onboarding_ui.gender.GenderScreen
import com.marmatsan.onboarding_ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLayerAppTheme {

                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { paddingValues ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.OnBoarding.WELCOME
                    ) {
                        composable(Route.OnBoarding.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.OnBoarding.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.OnBoarding.AGE) {

                        }
                        composable(Route.OnBoarding.HEIGHT) {

                        }
                        composable(Route.OnBoarding.WEIGHT) {

                        }
                        composable(Route.OnBoarding.NUTRIENT_GOAL) {

                        }
                        composable(Route.OnBoarding.ACTIVITY) {

                        }
                        composable(Route.OnBoarding.GOAL) {

                        }
                        composable(Route.Tracker.OVERVIEW) {

                        }
                        composable(Route.Tracker.SEARCH) {

                        }
                    }
                }
            }
        }
    }
}