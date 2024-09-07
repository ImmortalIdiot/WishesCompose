package com.immortalidiot.wishescompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.immortalidiot.wishescompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val ArchivoFontFamily = FontFamily(
    Font(R.font.archivo_light, FontWeight.Light),
    Font(R.font.archivo_medium, FontWeight.Medium),
    Font(R.font.archivo_semibold, FontWeight.SemiBold)
)

val TomorrowFontFamily = FontFamily(
    Font(R.font.tomorrow_light, FontWeight.Light)
)

private val lightArchivoStyle = TextStyle(
    fontFamily = ArchivoFontFamily,
    fontWeight = FontWeight.Light
)

private val mediumArchivoStyle = TextStyle(
    fontFamily = ArchivoFontFamily,
    fontWeight = FontWeight.Medium
)

private val semiBoldArchivoStyle = TextStyle(
    fontFamily = ArchivoFontFamily,
    fontWeight = FontWeight.SemiBold
)

private val lightTomorrowStyle = TextStyle(
    fontFamily = TomorrowFontFamily,
    fontWeight = FontWeight.Light
)

val modeHeaderText = mediumArchivoStyle.copy(fontSize = 30.sp)
val buttonText = semiBoldArchivoStyle.copy(fontSize = 24.sp)
val headerText = lightArchivoStyle.copy(fontSize = 22.sp)
val hintText = lightTomorrowStyle.copy(fontSize = 22.sp)
