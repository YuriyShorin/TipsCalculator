package course.google.tipscalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import course.google.tipscalculator.ui.theme.TipsCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipsCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipsCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipsCalculatorApp() {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var percentageInput by remember { mutableStateOf("15.0") }
    var percentage = percentageInput.toDoubleOrNull() ?: 15.0
    val tip = calculateTip(amount, percentage)
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(R.string.calculate_tip),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(start = 45.dp)
                .align(alignment = Alignment.Start)
        )
        Spacer(modifier = Modifier.height(15.dp))
        EditNumberField(
            modifier = Modifier
                .height(55.dp)
                .width(310.dp),
            value = amountInput,
            onValueChange = { amountInput = it },
            text = stringResource(R.string.bill_amount)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.padding(start = 30.dp, end = 30.dp)) {
            Button(
                modifier = Modifier
                    .height(55.dp)
                    .width(55.dp),
                onClick = {
                    percentage--
                    percentageInput = percentage.toString()
                },
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.ghost)),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(text = "-")
            }
            EditNumberField(
                modifier = Modifier
                    .height(55.dp)
                    .width(200.dp),
                value = percentageInput,
                onValueChange = { percentageInput = it },
                text = stringResource(R.string.percentage)
            )
            Button(
                modifier = Modifier
                    .height(55.dp)
                    .width(55.dp),
                onClick = {
                    percentage++
                    percentageInput = percentage.toString()
                },
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.ghost)),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(text = "+")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    text: String,
    modifier: Modifier
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = text, style = MaterialTheme.typography.bodyMedium) },
        textStyle = MaterialTheme.typography.titleMedium,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

private fun calculateTip(amount: Double, tipPercent: Double): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun TipsCalculatorAppPreview() {
    TipsCalculatorTheme {
        TipsCalculatorApp()
    }
}