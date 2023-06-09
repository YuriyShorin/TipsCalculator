package course.google.tipscalculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import course.google.tipscalculator.R

val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.helveticaneuecyr_black)),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black,
        textAlign = TextAlign.Start
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.helveticaneuecyr_roman)),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.helveticaneuecyr_black)),
        fontSize = 30.sp,
        lineHeight = 35.sp,
        letterSpacing = 0.7.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
)