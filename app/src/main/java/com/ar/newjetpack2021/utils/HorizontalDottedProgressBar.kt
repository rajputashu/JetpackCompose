package com.ar.newjetpack2021.utils

import androidx.compose.animation.core.*
import androidx.compose.animation.core.AnimationConstants.Infinite
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.ar.newjetpack2021.utils.SwellAnimationDefinitions.swellDefinition
import com.ar.newjetpack2021.utils.SwellAnimationDefinitions.swellPropKey


/**
 * This is not used in the project.
 */
object SwellAnimationDefinitions {

    enum class SwellState {
        FIRST, SECOND,
    }

    val swellPropKey = FloatPropKey("swell_key")

    val swellDefinition = transitionDefinition<SwellState> {
        state(SwellState.FIRST) { this[swellPropKey] = 0f }
        state(SwellState.SECOND) { this[swellPropKey] = 6f }

        transition(
            SwellState.FIRST to SwellState.SECOND,
        ) {
            swellPropKey using repeatable(
                iterations =  Infinite,
                animation = tween(
                    durationMillis = 700,
                    easing = LinearEasing
                )
            )
        }
    }
}


@Composable
fun HorizontalDottedProgressBar() {
    val color = MaterialTheme.colors.primary

    val swellAnim = transition(
        definition = swellDefinition,
        initState = SwellAnimationDefinitions.SwellState.FIRST,
        toState = SwellAnimationDefinitions.SwellState.SECOND
    )

    val state = swellAnim[swellPropKey]

    DrawCanvas(state = state, color = color)
}


@Composable
fun DrawCanvas(
    state: Float,
    color: Color,
){
    Canvas(
        modifier = Modifier.fillMaxWidth().height(55.dp),
    ){

        val radius = (4.dp).toIntPx().toFloat()
        val padding = (6.dp).toIntPx().toFloat()

        for(i in 1..5) {
            if(i-1 == state.toInt()){
                drawCircle(
                    radius = radius*2,
                    brush = SolidColor(color),
                    center = Offset(x = this.center.x + radius * 2 * (i-3)  + padding * (i-3), y = this.center.y)
                )
            }
            else{
                drawCircle(
                    radius = radius,
                    brush = SolidColor(color),
                    center = Offset(x = this.center.x + radius * 2 * (i-3) + padding * (i-3), y = this.center.y)
                )
            }
        }
    }
}

