import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun AutoSizeText(
    text: String,
    fontSize: Int,
    color: Color = Color.Black
) {
    val dynamicFontSize = calculateFontSize(fontSize, text.length)

    Text(
        text,
        maxLines = 1,
        overflow = TextOverflow.Visible,
        fontSize = dynamicFontSize.sp,
        color = color
    )
}

private fun calculateFontSize(
    fontSize: Int,
    textLength: Int,
): Float {

    val dynamicFontSize: Int = if (textLength < 8) {
        (fontSize + 20)
    }
    else if (textLength < 16) {
        (fontSize + 10)
    }
    else if (textLength < 32) {
        (fontSize + 5)
    }
    else {
        return (fontSize * (fontSize.toFloat() / (textLength)))
    }

    return dynamicFontSize.toFloat()

}