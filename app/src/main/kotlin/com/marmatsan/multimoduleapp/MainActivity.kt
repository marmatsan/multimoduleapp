package com.marmatsan.multimoduleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marmatsan.core_domain.navigation.Route
import com.marmatsan.multimoduleapp.navigation.navigate
import com.marmatsan.multimoduleapp.navigation.navigateBack
import com.marmatsan.multimoduleapp.ui.theme.MultiLayerAppTheme
import com.marmatsan.onboarding_ui.activity.ActivityScreen
import com.marmatsan.onboarding_ui.age.AgeScreen
import com.marmatsan.onboarding_ui.gender.GenderScreen
import com.marmatsan.onboarding_ui.weight_goal.GoalScreen
import com.marmatsan.onboarding_ui.height.HeightScreen
import com.marmatsan.onboarding_ui.nutrient_goal.NutrientGoalScreen
import com.marmatsan.onboarding_ui.weight.WeightScreen
import com.marmatsan.onboarding_ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLayerAppTheme {

                val snackbarHostState = remember { SnackbarHostState() }

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
                            WelcomeScreen(
                                modifier = Modifier.padding(paddingValues),
                                onNavigate = navController::navigate,
                            )
                        }
                        composable(Route.OnBoarding.GENDER) {
                            GenderScreen(
                                modifier = Modifier.padding(paddingValues),
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.OnBoarding.AGE) {
                            AgeScreen(
                                modifier = Modifier.padding(paddingValues),
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate,
                                onNavigateBack = navController::navigateBack
                            )
                        }
                        composable(Route.OnBoarding.HEIGHT) {
                            HeightScreen(
                                modifier = Modifier.padding(paddingValues),
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate,
                                onNavigateBack = navController::navigateBack
                            )
                        }
                        composable(Route.OnBoarding.WEIGHT) {
                            WeightScreen(
                                modifier = Modifier.padding(paddingValues),
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate,
                                onNavigateBack = navController::navigateBack
                            )
                        }
                        composable(Route.OnBoarding.ACTIVITY) {
                            ActivityScreen(
                                modifier = Modifier.padding(paddingValues),
                                onNavigate = navController::navigate,
                                onNavigateBack = navController::navigateBack
                            )
                        }
                        composable(Route.OnBoarding.WEIGHT_GOAL) {
                            GoalScreen(
                                modifier = Modifier.padding(paddingValues),
                                onNavigate = navController::navigate,
                                onNavigateBack = navController::navigateBack
                            )
                        }
                        composable(Route.OnBoarding.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                modifier = Modifier.padding(paddingValues),
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
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