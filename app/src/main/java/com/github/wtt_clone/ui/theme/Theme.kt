package com.example.compose

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.github.wtt_clone.ui.theme.Typography
import com.github.wtt_clone.ui.theme.backgroundDark
import com.github.wtt_clone.ui.theme.backgroundDarkHighContrast
import com.github.wtt_clone.ui.theme.backgroundDarkMediumContrast
import com.github.wtt_clone.ui.theme.backgroundLight
import com.github.wtt_clone.ui.theme.backgroundLightHighContrast
import com.github.wtt_clone.ui.theme.backgroundLightMediumContrast
import com.github.wtt_clone.ui.theme.errorContainerDark
import com.github.wtt_clone.ui.theme.errorContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.errorContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.errorContainerLight
import com.github.wtt_clone.ui.theme.errorContainerLightHighContrast
import com.github.wtt_clone.ui.theme.errorContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.errorDark
import com.github.wtt_clone.ui.theme.errorDarkHighContrast
import com.github.wtt_clone.ui.theme.errorDarkMediumContrast
import com.github.wtt_clone.ui.theme.errorLight
import com.github.wtt_clone.ui.theme.errorLightHighContrast
import com.github.wtt_clone.ui.theme.errorLightMediumContrast
import com.github.wtt_clone.ui.theme.inverseOnSurfaceDark
import com.github.wtt_clone.ui.theme.inverseOnSurfaceDarkHighContrast
import com.github.wtt_clone.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.github.wtt_clone.ui.theme.inverseOnSurfaceLight
import com.github.wtt_clone.ui.theme.inverseOnSurfaceLightHighContrast
import com.github.wtt_clone.ui.theme.inverseOnSurfaceLightMediumContrast
import com.github.wtt_clone.ui.theme.inversePrimaryDark
import com.github.wtt_clone.ui.theme.inversePrimaryDarkHighContrast
import com.github.wtt_clone.ui.theme.inversePrimaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.inversePrimaryLight
import com.github.wtt_clone.ui.theme.inversePrimaryLightHighContrast
import com.github.wtt_clone.ui.theme.inversePrimaryLightMediumContrast
import com.github.wtt_clone.ui.theme.inverseSurfaceDark
import com.github.wtt_clone.ui.theme.inverseSurfaceDarkHighContrast
import com.github.wtt_clone.ui.theme.inverseSurfaceDarkMediumContrast
import com.github.wtt_clone.ui.theme.inverseSurfaceLight
import com.github.wtt_clone.ui.theme.inverseSurfaceLightHighContrast
import com.github.wtt_clone.ui.theme.inverseSurfaceLightMediumContrast
import com.github.wtt_clone.ui.theme.onBackgroundDark
import com.github.wtt_clone.ui.theme.onBackgroundDarkHighContrast
import com.github.wtt_clone.ui.theme.onBackgroundDarkMediumContrast
import com.github.wtt_clone.ui.theme.onBackgroundLight
import com.github.wtt_clone.ui.theme.onBackgroundLightHighContrast
import com.github.wtt_clone.ui.theme.onBackgroundLightMediumContrast
import com.github.wtt_clone.ui.theme.onErrorContainerDark
import com.github.wtt_clone.ui.theme.onErrorContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.onErrorContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.onErrorContainerLight
import com.github.wtt_clone.ui.theme.onErrorContainerLightHighContrast
import com.github.wtt_clone.ui.theme.onErrorContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.onErrorDark
import com.github.wtt_clone.ui.theme.onErrorDarkHighContrast
import com.github.wtt_clone.ui.theme.onErrorDarkMediumContrast
import com.github.wtt_clone.ui.theme.onErrorLight
import com.github.wtt_clone.ui.theme.onErrorLightHighContrast
import com.github.wtt_clone.ui.theme.onErrorLightMediumContrast
import com.github.wtt_clone.ui.theme.onPrimaryContainerDark
import com.github.wtt_clone.ui.theme.onPrimaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.onPrimaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.onPrimaryContainerLight
import com.github.wtt_clone.ui.theme.onPrimaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.onPrimaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.onPrimaryDark
import com.github.wtt_clone.ui.theme.onPrimaryDarkHighContrast
import com.github.wtt_clone.ui.theme.onPrimaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.onPrimaryLight
import com.github.wtt_clone.ui.theme.onPrimaryLightHighContrast
import com.github.wtt_clone.ui.theme.onPrimaryLightMediumContrast
import com.github.wtt_clone.ui.theme.onSecondaryContainerDark
import com.github.wtt_clone.ui.theme.onSecondaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.onSecondaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.onSecondaryContainerLight
import com.github.wtt_clone.ui.theme.onSecondaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.onSecondaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.onSecondaryDark
import com.github.wtt_clone.ui.theme.onSecondaryDarkHighContrast
import com.github.wtt_clone.ui.theme.onSecondaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.onSecondaryLight
import com.github.wtt_clone.ui.theme.onSecondaryLightHighContrast
import com.github.wtt_clone.ui.theme.onSecondaryLightMediumContrast
import com.github.wtt_clone.ui.theme.onSurfaceDark
import com.github.wtt_clone.ui.theme.onSurfaceDarkHighContrast
import com.github.wtt_clone.ui.theme.onSurfaceDarkMediumContrast
import com.github.wtt_clone.ui.theme.onSurfaceLight
import com.github.wtt_clone.ui.theme.onSurfaceLightHighContrast
import com.github.wtt_clone.ui.theme.onSurfaceLightMediumContrast
import com.github.wtt_clone.ui.theme.onSurfaceVariantDark
import com.github.wtt_clone.ui.theme.onSurfaceVariantDarkHighContrast
import com.github.wtt_clone.ui.theme.onSurfaceVariantDarkMediumContrast
import com.github.wtt_clone.ui.theme.onSurfaceVariantLight
import com.github.wtt_clone.ui.theme.onSurfaceVariantLightHighContrast
import com.github.wtt_clone.ui.theme.onSurfaceVariantLightMediumContrast
import com.github.wtt_clone.ui.theme.onTertiaryContainerDark
import com.github.wtt_clone.ui.theme.onTertiaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.onTertiaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.onTertiaryContainerLight
import com.github.wtt_clone.ui.theme.onTertiaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.onTertiaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.onTertiaryDark
import com.github.wtt_clone.ui.theme.onTertiaryDarkHighContrast
import com.github.wtt_clone.ui.theme.onTertiaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.onTertiaryLight
import com.github.wtt_clone.ui.theme.onTertiaryLightHighContrast
import com.github.wtt_clone.ui.theme.onTertiaryLightMediumContrast
import com.github.wtt_clone.ui.theme.outlineDark
import com.github.wtt_clone.ui.theme.outlineDarkHighContrast
import com.github.wtt_clone.ui.theme.outlineDarkMediumContrast
import com.github.wtt_clone.ui.theme.outlineLight
import com.github.wtt_clone.ui.theme.outlineLightHighContrast
import com.github.wtt_clone.ui.theme.outlineLightMediumContrast
import com.github.wtt_clone.ui.theme.outlineVariantDark
import com.github.wtt_clone.ui.theme.outlineVariantDarkHighContrast
import com.github.wtt_clone.ui.theme.outlineVariantDarkMediumContrast
import com.github.wtt_clone.ui.theme.outlineVariantLight
import com.github.wtt_clone.ui.theme.outlineVariantLightHighContrast
import com.github.wtt_clone.ui.theme.outlineVariantLightMediumContrast
import com.github.wtt_clone.ui.theme.primaryContainerDark
import com.github.wtt_clone.ui.theme.primaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.primaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.primaryContainerLight
import com.github.wtt_clone.ui.theme.primaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.primaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.primaryDark
import com.github.wtt_clone.ui.theme.primaryDarkHighContrast
import com.github.wtt_clone.ui.theme.primaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.primaryLight
import com.github.wtt_clone.ui.theme.primaryLightHighContrast
import com.github.wtt_clone.ui.theme.primaryLightMediumContrast
import com.github.wtt_clone.ui.theme.scrimDark
import com.github.wtt_clone.ui.theme.scrimDarkHighContrast
import com.github.wtt_clone.ui.theme.scrimDarkMediumContrast
import com.github.wtt_clone.ui.theme.scrimLight
import com.github.wtt_clone.ui.theme.scrimLightHighContrast
import com.github.wtt_clone.ui.theme.scrimLightMediumContrast
import com.github.wtt_clone.ui.theme.secondaryContainerDark
import com.github.wtt_clone.ui.theme.secondaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.secondaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.secondaryContainerLight
import com.github.wtt_clone.ui.theme.secondaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.secondaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.secondaryDark
import com.github.wtt_clone.ui.theme.secondaryDarkHighContrast
import com.github.wtt_clone.ui.theme.secondaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.secondaryLight
import com.github.wtt_clone.ui.theme.secondaryLightHighContrast
import com.github.wtt_clone.ui.theme.secondaryLightMediumContrast
import com.github.wtt_clone.ui.theme.surfaceDark
import com.github.wtt_clone.ui.theme.surfaceDarkHighContrast
import com.github.wtt_clone.ui.theme.surfaceDarkMediumContrast
import com.github.wtt_clone.ui.theme.surfaceLight
import com.github.wtt_clone.ui.theme.surfaceLightHighContrast
import com.github.wtt_clone.ui.theme.surfaceLightMediumContrast
import com.github.wtt_clone.ui.theme.surfaceVariantDark
import com.github.wtt_clone.ui.theme.surfaceVariantDarkHighContrast
import com.github.wtt_clone.ui.theme.surfaceVariantDarkMediumContrast
import com.github.wtt_clone.ui.theme.surfaceVariantLight
import com.github.wtt_clone.ui.theme.surfaceVariantLightHighContrast
import com.github.wtt_clone.ui.theme.surfaceVariantLightMediumContrast
import com.github.wtt_clone.ui.theme.tertiaryContainerDark
import com.github.wtt_clone.ui.theme.tertiaryContainerDarkHighContrast
import com.github.wtt_clone.ui.theme.tertiaryContainerDarkMediumContrast
import com.github.wtt_clone.ui.theme.tertiaryContainerLight
import com.github.wtt_clone.ui.theme.tertiaryContainerLightHighContrast
import com.github.wtt_clone.ui.theme.tertiaryContainerLightMediumContrast
import com.github.wtt_clone.ui.theme.tertiaryDark
import com.github.wtt_clone.ui.theme.tertiaryDarkHighContrast
import com.github.wtt_clone.ui.theme.tertiaryDarkMediumContrast
import com.github.wtt_clone.ui.theme.tertiaryLight
import com.github.wtt_clone.ui.theme.tertiaryLightHighContrast
import com.github.wtt_clone.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> darkScheme
//        else -> lightScheme
//    }
    val colorScheme = darkScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.inversePrimary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography,
    )
}