package com.marmatsan.tracker_ui.tracker_overview.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marmatsan.core_ui.theme.CarbColor
import com.marmatsan.core_ui.theme.FatColor
import com.marmatsan.core_ui.theme.ProteinColor

@Composable
fun NutrientsBar(
    modifier: Modifier = Modifier,
    carbs: Int,
    protein: Int,
    fat: Int,
    calories: Int,
    calorieGoal: Int
) {

    val carbWidthRatio = remember {
        Animatable(0f)
    }
    val proteinWidthRatio = remember {
        Animatable(0f)
    }
    val fatWidthRatio = remember {
        Animatable(0f)
    }

    LaunchedEffect(carbs) {
        carbWidthRatio.animateTo(
            targetValue = ((carbs * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(protein) {
        proteinWidthRatio.animateTo(
            targetValue = ((protein * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(fat) {
        fatWidthRatio.animateTo(
            targetValue = ((fat * 9f) / calorieGoal)
        )
    }

    NutrientsBarContent(
        modifier = modifier,
        calories = calories,
        calorieGoal = calorieGoal,
        carbWidthRatio = carbWidthRatio.value,
        proteinWidthRatio = proteinWidthRatio.value,
        fatWidthRatio = fatWidthRatio.value
    )
}

@Composable
fun NutrientsBarContent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    errorColor: Color = MaterialTheme.colorScheme.error,
    calories: Int,
    calorieGoal: Int,
    carbWidthRatio: Float,
    proteinWidthRatio: Float,
    fatWidthRatio: Float
) {
    Canvas(
        modifier = modifier
    ) {
        if (calories <= calorieGoal) {
            val carbsWidth = carbWidthRatio * size.width
            val proteinWidth = proteinWidthRatio * size.width
            val fatWidth = fatWidthRatio * size.width
            drawRoundRect(
                color = backgroundColor,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = FatColor,
                size = Size(
                    width = carbsWidth + proteinWidth + fatWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = ProteinColor,
                size = Size(
                    width = carbsWidth + proteinWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = CarbColor,
                size = Size(
                    width = carbsWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
        } else {
            drawRoundRect(
                color = errorColor,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun NutrientsBarContentPreview() {
    val modifier: Modifier = Modifier
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NutrientsBarContent( // TODO: Improve
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            calories = 100,
            calorieGoal = 500,
            carbWidthRatio = 10f,
            proteinWidthRatio = 10f,
            fatWidthRatio = 10f
        )
    }
}