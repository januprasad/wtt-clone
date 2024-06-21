package com.github.wtt_clone

import androidx.compose.ui.graphics.Brush
import com.github.wtt_clone.ui.theme.orange
import com.github.wtt_clone.ui.theme.red

object Constants{
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            red,
            orange
        )
    )
}