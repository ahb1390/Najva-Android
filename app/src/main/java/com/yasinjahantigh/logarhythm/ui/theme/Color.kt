package com.yasinjahantigh.logarhythm.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

/*
 * LogaRhythm's signature palette: "Ink & Ember".
 * Dark mode is warm ink with an ember-amber accent, like a stage lit from one side;
 * light mode is warm paper with burnt-amber type accents. Slate blue and sage supply the
 * secondary and tertiary voices so a single hue never carries the whole interface.
 * Every surface role is set explicitly so no tone leaks in from the Material baseline.
 */

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFF4B266),
    onPrimary = Color(0xFF3A2100),
    primaryContainer = Color(0xFF5E3A0C),
    onPrimaryContainer = Color(0xFFFFDDB5),
    inversePrimary = Color(0xFF8A4F00),

    secondary = Color(0xFFB9C8D6),
    onSecondary = Color(0xFF22323F),
    secondaryContainer = Color(0xFF33424F),
    onSecondaryContainer = Color(0xFFD5E4F3),

    tertiary = Color(0xFFA8CFB5),
    onTertiary = Color(0xFF123824),
    tertiaryContainer = Color(0xFF2C4F3A),
    onTertiaryContainer = Color(0xFFC3EBD0),

    background = Color(0xFF0E1013),
    onBackground = Color(0xFFE8E4DC),
    surface = Color(0xFF0E1013),
    onSurface = Color(0xFFE8E4DC),
    surfaceVariant = Color(0xFF3A3A3D),
    onSurfaceVariant = Color(0xFFC2BDB3),
    surfaceTint = Color(0xFFF4B266),
    inverseSurface = Color(0xFFE8E4DC),
    inverseOnSurface = Color(0xFF2F3033),

    surfaceDim = Color(0xFF0E1013),
    surfaceBright = Color(0xFF2A2D33),
    surfaceContainerLowest = Color(0xFF0A0C0E),
    surfaceContainerLow = Color(0xFF15181C),
    surfaceContainer = Color(0xFF191C21),
    surfaceContainerHigh = Color(0xFF202429),
    surfaceContainerHighest = Color(0xFF2A2E34),

    outline = Color(0xFF8C877E),
    outlineVariant = Color(0xFF3F3C37),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

/** Pure-black surfaces for OLED panels; the amber ink stays the same, only the canvas changes. */
val OledColorScheme = DarkColorScheme.copy(
    background = Color.Black,
    surface = Color.Black,
    surfaceDim = Color.Black,
    surfaceBright = Color(0xFF242424),
    surfaceContainerLowest = Color.Black,
    surfaceContainerLow = Color(0xFF060606),
    surfaceContainer = Color(0xFF0B0B0B),
    surfaceContainerHigh = Color(0xFF121212),
    surfaceContainerHighest = Color(0xFF181818),
    surfaceVariant = Color(0xFF1F1F1F),
    outlineVariant = Color(0xFF2A2A2A),
    inverseSurface = Color(0xFFE8E4DC)
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF8A4F00),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDDB5),
    onPrimaryContainer = Color(0xFF2C1700),
    inversePrimary = Color(0xFFF4B266),

    secondary = Color(0xFF4A6174),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFCDE5FA),
    onSecondaryContainer = Color(0xFF041E30),

    tertiary = Color(0xFF3F6A50),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFC1EFD0),
    onTertiaryContainer = Color(0xFF00210F),

    background = Color(0xFFFBF8F2),
    onBackground = Color(0xFF1D1B17),
    surface = Color(0xFFFBF8F2),
    onSurface = Color(0xFF1D1B17),
    surfaceVariant = Color(0xFFE9E2D3),
    onSurfaceVariant = Color(0xFF4C4639),
    surfaceTint = Color(0xFF8A4F00),
    inverseSurface = Color(0xFF32302B),
    inverseOnSurface = Color(0xFFF6F0E7),

    surfaceDim = Color(0xFFDDD9D1),
    surfaceBright = Color(0xFFFBF8F2),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFF6F2EA),
    surfaceContainer = Color(0xFFF1ECE3),
    surfaceContainerHigh = Color(0xFFEBE6DC),
    surfaceContainerHighest = Color(0xFFE5E0D6),

    outline = Color(0xFF7E7667),
    outlineVariant = Color(0xFFD0C9B9),

    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002)
)

private fun tone(hue: Float, saturation: Float, lightness: Float): Color =
    Color(ColorUtils.HSLToColor(floatArrayOf(((hue % 360f) + 360f) % 360f, saturation.coerceIn(0f, 1f), lightness.coerceIn(0f, 1f))))

/**
 * Builds a complete Material 3 scheme from the playing album's dominant color. Surface-container
 * roles are derived from the same hue, so cards and sheets are tinted by the artwork instead of
 * falling back to the Material baseline's purple-grey.
 */
fun generateDynamicSchemeFromSeed(seed: Color, isDark: Boolean): ColorScheme {
    val hsl = FloatArray(3)
    ColorUtils.colorToHSL(seed.toArgb(), hsl)

    val hue = hsl[0]
    val sat = hsl[1].coerceIn(0.3f, 0.85f)
    val secondaryHue = hue + 24f
    val tertiaryHue = hue + 150f

    return if (isDark) {
        val primary = tone(hue, sat, 0.75f)
        val surface = tone(hue, 0.12f, 0.08f)
        darkColorScheme(
            primary = primary,
            onPrimary = tone(hue, sat, 0.12f),
            primaryContainer = tone(hue, sat, 0.25f),
            onPrimaryContainer = tone(hue, sat, 0.90f),
            secondary = tone(secondaryHue, sat * 0.45f, 0.78f),
            onSecondary = tone(secondaryHue, sat * 0.45f, 0.14f),
            secondaryContainer = tone(secondaryHue, sat * 0.35f, 0.26f),
            onSecondaryContainer = tone(secondaryHue, sat * 0.45f, 0.90f),
            tertiary = tone(tertiaryHue, sat * 0.45f, 0.78f),
            onTertiary = tone(tertiaryHue, sat * 0.45f, 0.14f),
            tertiaryContainer = tone(tertiaryHue, sat * 0.35f, 0.26f),
            onTertiaryContainer = tone(tertiaryHue, sat * 0.45f, 0.90f),
            surface = surface,
            background = surface,
            onSurface = Color(0xFFE5E5E5),
            onBackground = Color(0xFFE5E5E5),
            surfaceVariant = tone(hue, 0.15f, 0.20f),
            onSurfaceVariant = Color(0xFFC4C7C5),
            surfaceTint = primary,
            surfaceDim = surface,
            surfaceBright = tone(hue, 0.12f, 0.20f),
            surfaceContainerLowest = tone(hue, 0.12f, 0.05f),
            surfaceContainerLow = tone(hue, 0.12f, 0.10f),
            surfaceContainer = tone(hue, 0.12f, 0.12f),
            surfaceContainerHigh = tone(hue, 0.12f, 0.15f),
            surfaceContainerHighest = tone(hue, 0.12f, 0.19f),
            outline = tone(hue, 0.08f, 0.55f),
            outlineVariant = tone(hue, 0.10f, 0.28f)
        )
    } else {
        val primary = tone(hue, sat, 0.38f)
        val surface = tone(hue, 0.10f, 0.98f)
        lightColorScheme(
            primary = primary,
            onPrimary = Color.White,
            primaryContainer = tone(hue, sat, 0.88f),
            onPrimaryContainer = tone(hue, sat, 0.14f),
            secondary = tone(secondaryHue, sat * 0.45f, 0.38f),
            onSecondary = Color.White,
            secondaryContainer = tone(secondaryHue, sat * 0.40f, 0.88f),
            onSecondaryContainer = tone(secondaryHue, sat * 0.45f, 0.14f),
            tertiary = tone(tertiaryHue, sat * 0.45f, 0.36f),
            onTertiary = Color.White,
            tertiaryContainer = tone(tertiaryHue, sat * 0.40f, 0.88f),
            onTertiaryContainer = tone(tertiaryHue, sat * 0.45f, 0.14f),
            surface = surface,
            background = surface,
            onSurface = Color(0xFF1B1B1B),
            onBackground = Color(0xFF1B1B1B),
            surfaceVariant = tone(hue, 0.15f, 0.90f),
            onSurfaceVariant = Color(0xFF444746),
            surfaceTint = primary,
            surfaceDim = tone(hue, 0.08f, 0.87f),
            surfaceBright = surface,
            surfaceContainerLowest = Color.White,
            surfaceContainerLow = tone(hue, 0.10f, 0.96f),
            surfaceContainer = tone(hue, 0.10f, 0.94f),
            surfaceContainerHigh = tone(hue, 0.10f, 0.92f),
            surfaceContainerHighest = tone(hue, 0.10f, 0.90f),
            outline = tone(hue, 0.06f, 0.46f),
            outlineVariant = tone(hue, 0.10f, 0.80f)
        )
    }
}

/**
 * Najva's selectable brand palettes. The built-in palettes own their complete canvas
 * and container colors in both light and dark modes; OLED must not erase their identity.
 */
fun najvaBrandColorScheme(palette: String, isDark: Boolean, oled: Boolean = false): ColorScheme {
    val ashura = palette == "ashura"
    val gold = if (isDark) Color(0xFFE8C878) else Color(0xFF8A641C)

    return if (ashura) {
        if (isDark) {
            darkColorScheme(
                primary = Color(0xFFFF777B), onPrimary = Color(0xFF4A0710),
                primaryContainer = Color(0xFF79202B), onPrimaryContainer = Color(0xFFFFDADB),
                inversePrimary = Color(0xFF9F2435),
                secondary = gold, onSecondary = Color(0xFF382600),
                secondaryContainer = Color(0xFF5A4218), onSecondaryContainer = Color(0xFFFFE8B0),
                tertiary = Color(0xFFE9A0A0), onTertiary = Color(0xFF4A1018),
                tertiaryContainer = Color(0xFF61232B), onTertiaryContainer = Color(0xFFFFDADB),
                background = Color(0xFF351018), onBackground = Color(0xFFFFE9E9),
                surface = Color(0xFF3D121B), onSurface = Color(0xFFFFE9E9),
                surfaceVariant = Color(0xFF64232D), onSurfaceVariant = Color(0xFFEBC4C5),
                surfaceTint = Color(0xFFFF777B), inverseSurface = Color(0xFFF8E4E5),
                inverseOnSurface = Color(0xFF3A1018), surfaceDim = Color(0xFF2D0C13),
                surfaceBright = Color(0xFF64232D), surfaceContainerLowest = Color(0xFF2A0B12),
                surfaceContainerLow = Color(0xFF39121A), surfaceContainer = Color(0xFF43151F),
                surfaceContainerHigh = Color(0xFF4D1A24), surfaceContainerHighest = Color(0xFF59202A),
                outline = Color(0xFFB8797D), outlineVariant = Color(0xFF78343D),
                error = Color(0xFFFFB4AB), onError = Color(0xFF690005),
                errorContainer = Color(0xFF93000A), onErrorContainer = Color(0xFFFFDAD6)
            )
        } else {
            lightColorScheme(
                primary = Color(0xFFAD2638), onPrimary = Color(0xFFFFF0F0),
                primaryContainer = Color(0xFFF3BFC5), onPrimaryContainer = Color(0xFF4A0710),
                inversePrimary = Color(0xFFFF777B),
                secondary = gold, onSecondary = Color(0xFFFFF7E6),
                secondaryContainer = Color(0xFFF1DDAF), onSecondaryContainer = Color(0xFF382600),
                tertiary = Color(0xFF9D4650), onTertiary = Color(0xFFFFF0F0),
                tertiaryContainer = Color(0xFFF4D0D2), onTertiaryContainer = Color(0xFF4A1018),
                background = Color(0xFFF4DADD), onBackground = Color(0xFF42131B),
                surface = Color(0xFFF8E5E7), onSurface = Color(0xFF42131B),
                surfaceVariant = Color(0xFFEBC6CA), onSurfaceVariant = Color(0xFF63323A),
                surfaceTint = Color(0xFFAD2638), inverseSurface = Color(0xFF4B1720),
                inverseOnSurface = Color(0xFFFFE9E9), surfaceDim = Color(0xFFE8C4C8),
                surfaceBright = Color(0xFFF9E9EA), surfaceContainerLowest = Color(0xFFFBEAEC),
                surfaceContainerLow = Color(0xFFF6E0E2), surfaceContainer = Color(0xFFF0D5D8),
                surfaceContainerHigh = Color(0xFFEBCBD0), surfaceContainerHighest = Color(0xFFE5C1C6),
                outline = Color(0xFF896068), outlineVariant = Color(0xFFD8AEB4),
                error = Color(0xFFBA1A1A), onError = Color(0xFFFFF0F0),
                errorContainer = Color(0xFFFFDAD6), onErrorContainer = Color(0xFF410002)
            )
        }
    } else {
        if (isDark) {
            darkColorScheme(
                primary = Color(0xFF43D9A0), onPrimary = Color(0xFF003824),
                primaryContainer = Color(0xFF086044), onPrimaryContainer = Color(0xFFB9F5D8),
                inversePrimary = Color(0xFF087B59),
                secondary = gold, onSecondary = Color(0xFF302400),
                secondaryContainer = Color(0xFF514014), onSecondaryContainer = Color(0xFFFFE7A8),
                tertiary = Color(0xFF9BD7B6), onTertiary = Color(0xFF073B2B),
                tertiaryContainer = Color(0xFF18543F), onTertiaryContainer = Color(0xFFC4F2D8),
                background = Color(0xFF073B2C), onBackground = Color(0xFFE0F4E7),
                surface = Color(0xFF084332), onSurface = Color(0xFFE0F4E7),
                surfaceVariant = Color(0xFF185B45), onSurfaceVariant = Color(0xFFBBDCC9),
                surfaceTint = Color(0xFF43D9A0), inverseSurface = Color(0xFFDDEFE3),
                inverseOnSurface = Color(0xFF123D2E), surfaceDim = Color(0xFF052F23),
                surfaceBright = Color(0xFF23674F), surfaceContainerLowest = Color(0xFF052D22),
                surfaceContainerLow = Color(0xFF07392A), surfaceContainer = Color(0xFF0A4634),
                surfaceContainerHigh = Color(0xFF10513D), surfaceContainerHighest = Color(0xFF185D46),
                outline = Color(0xFF83B99D), outlineVariant = Color(0xFF326E55),
                error = Color(0xFFFFB4AB), onError = Color(0xFF690005),
                errorContainer = Color(0xFF93000A), onErrorContainer = Color(0xFFFFDAD6)
            )
        } else {
            lightColorScheme(
                primary = Color(0xFF087B59), onPrimary = Color(0xFFE9FFF3),
                primaryContainer = Color(0xFFB5E8CE), onPrimaryContainer = Color(0xFF003824),
                inversePrimary = Color(0xFF43D9A0),
                secondary = gold, onSecondary = Color(0xFFFFF8E8),
                secondaryContainer = Color(0xFFF0E1B8), onSecondaryContainer = Color(0xFF302400),
                tertiary = Color(0xFF397A59), onTertiary = Color(0xFFF0FFF5),
                tertiaryContainer = Color(0xFFC6E8D2), onTertiaryContainer = Color(0xFF123D2B),
                background = Color(0xFFDCEBDD), onBackground = Color(0xFF123D2B),
                surface = Color(0xFFE5F0E4), onSurface = Color(0xFF123D2B),
                surfaceVariant = Color(0xFFC9DEC9), onSurfaceVariant = Color(0xFF365A43),
                surfaceTint = Color(0xFF087B59), inverseSurface = Color(0xFF174532),
                inverseOnSurface = Color(0xFFE5F0E4), surfaceDim = Color(0xFFD0E2D1),
                surfaceBright = Color(0xFFECF4E9), surfaceContainerLowest = Color(0xFFEAF3E7),
                surfaceContainerLow = Color(0xFFE3EEE1), surfaceContainer = Color(0xFFDDE9DA),
                surfaceContainerHigh = Color(0xFFD5E4D3), surfaceContainerHighest = Color(0xFFCCDECA),
                outline = Color(0xFF66836D), outlineVariant = Color(0xFFB4CDB6),
                error = Color(0xFFBA1A1A), onError = Color(0xFFEAF3E7),
                errorContainer = Color(0xFFFFDAD6), onErrorContainer = Color(0xFF410002)
            )
        }
    }
}
