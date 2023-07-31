package com.marmatsan.multilayerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marmatsan.core.navigation.Routes
import com.marmatsan.multilayerapp.navigation.navigate
import com.marmatsan.multilayerapp.ui.theme.MultiLayerAppTheme
import com.marmatsan.onboarding_ui.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLayerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.OnBoarding.WELCOME
                    ) {
                        composable(Routes.OnBoarding.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Routes.OnBoarding.AGE) {

                        }
                        composable(Routes.OnBoarding.GENDER) {

                        }
                        composable(Routes.OnBoarding.HEIGHT) {

                        }
                        composable(Routes.OnBoarding.WEIGHT) {

                        }
                        composable(Routes.OnBoarding.NUTRIENT_GOAL) {

                        }
                        composable(Routes.OnBoarding.ACTIVITY) {

                        }
                        composable(Routes.OnBoarding.GOAL) {

                        }
                        composable(Routes.Tracker.OVERVIEW) {

                        }
                        composable(Routes.Tracker.SEARCH) {

                        }
                    }
                }
            }
        }
    }
}