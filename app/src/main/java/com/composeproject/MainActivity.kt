package com.composeproject

import android.media.Rating
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressBar(percentage = 0.8f, number = 100)
            }
        }
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    var isAnimationPlayed by remember {
        mutableStateOf(false)
    }
    // We animate the float value from the old to the new value
    val currentPercentage = animateFloatAsState(
        targetValue = if (isAnimationPlayed) percentage else 0f,
        animationSpec =
        tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )
    LaunchedEffect(key1 = true) {
        isAnimationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f) //How big our circle will be
    ) {
        //Canvas is to draw our own shapes
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false, //To not connect the lines with the center
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}