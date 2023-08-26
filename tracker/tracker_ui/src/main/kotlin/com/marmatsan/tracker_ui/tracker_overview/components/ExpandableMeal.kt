package com.marmatsan.tracker_ui.tracker_overview.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marmatsan.core_domain.util.UiText
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.tracker_domain.model.Meal
import com.marmatsan.tracker_ui.components.NutrientInfo
import com.marmatsan.tracker_ui.components.UnitDisplay
import com.marmatsan.tracker_ui.tracker_overview.MealUi
import com.marmatsan.tracker_ui.R

@Composable
fun ExpandableMeal(
    modifier: Modifier = Modifier,
    meal: MealUi,
    onToggleClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onToggleClick() }
                .padding(spacing.spaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = meal.drawableRes),
                contentDescription = meal.name.asString(context)
            )
            Spacer(
                modifier = Modifier.width(spacing.spaceMedium)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = meal.name.asString(context),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Icon(
                        imageVector = if (meal.isExpanded) {
                            Icons.Default.KeyboardArrowUp
                        } else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (meal.isExpanded) {
                            stringResource(id = R.string.collapse)
                        } else stringResource(id = R.string.extend)
                    )
                }
                Spacer(
                    modifier = Modifier.height(spacing.spaceSmall)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UnitDisplay(
                        amount = meal.calories,
                        amountColor = MaterialTheme.colorScheme.onBackground,
                        unitColor = MaterialTheme.colorScheme.onBackground,
                        unit = stringResource(id = R.string.kcal),
                        amountTextSize = 30.sp
                    )
                    Row {
                        NutrientInfo(
                            name = stringResource(id = R.string.carbs),
                            amount = meal.carbs,
                            unit = stringResource(id = R.string.grams)
                        )
                        Spacer(
                            modifier = Modifier.width(spacing.spaceSmall)
                        )
                        NutrientInfo(
                            name = stringResource(id = R.string.protein),
                            amount = meal.protein,
                            unit = stringResource(id = R.string.grams)
                        )
                        Spacer(
                            modifier = Modifier.width(spacing.spaceSmall)
                        )
                        NutrientInfo(
                            name = stringResource(id = R.string.fat),
                            amount = meal.fat,
                            unit = stringResource(id = R.string.grams)
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier.height(spacing.spaceMedium)
        )
        AnimatedVisibility(visible = meal.isExpanded) {
            content()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ExpandableMealPreview() {
    ExpandableMeal(
        meal = MealUi(
            name = UiText.DynamicString("Breakfast"),
            drawableRes = R.drawable.ic_breakfast,
            meal = Meal.Breakfast
        ),
        onToggleClick = { },
        content = { }
    )
}