package com.github.wtt_clone

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit = 24.sp,
    color: Color = Color.White
) {
    Text(
        text = text,
        color = color,
        fontWeight = FontWeight.ExtraBold,
        style = TextStyle.Default.copy(
            fontSize = size,
            fontFamily = familyBioSans,
            letterSpacing = 0.5.sp,
        ),
        modifier = modifier,
    )
}

@Composable
fun DescriptionText(text: String, size: TextUnit = 16.sp, modifier: Modifier = Modifier, maxLines: Int = Int.MAX_VALUE) {
    Text(
        text = text, style = TextStyle.Default.copy(
            fontSize = 16.sp,
            fontFamily = familyHelveticaNeue,
            letterSpacing = 0.5.sp,
            lineHeight = 21.sp,
        ),
        modifier = modifier,
        maxLines = maxLines,
    )
}