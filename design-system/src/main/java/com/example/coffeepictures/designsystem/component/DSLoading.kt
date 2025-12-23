package com.example.coffeepictures.designsystem.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeepictures.designsystem.CoffeePicturesPreview

@Composable
fun DSLoading(
    modifier: Modifier = Modifier,
) {
    val transition = rememberInfiniteTransition()

    val alpha by transition.animateFloat(
        initialValue = 0.25F,
        targetValue = 1F,
        animationSpec =
            infiniteRepeatable(
                animation =
                    tween(
                        durationMillis = 500,
                    ),
                repeatMode = RepeatMode.Reverse,
            )
    )

    Box(
        modifier =
            modifier
                .alpha(alpha)
                .background(Color.Gray),
    )
}

@Preview
@Composable
private fun DSLoadingPreview() {
    CoffeePicturesPreview(
        modifier = Modifier.background(Color.White),
    ) {
        DSLoading(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
        )
    }
}
