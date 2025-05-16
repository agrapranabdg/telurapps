import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDate(
    selectedDate: String?,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    val displayText = selectedDate ?: "Pilih Tanggal"

    Column(modifier = modifier) {
        OutlinedTextField(
            value = displayText,
            onValueChange = {},
            readOnly = true,
            label = { Text("Tanggal") },
            trailingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = "Pilih Tanggal")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { showDatePicker = true }
        )

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            datePickerState.selectedDateMillis?.let { millis ->
                                val formatted = convertMillisToIndoDate(millis)
                                onDateSelected(formatted)
                            }
                            showDatePicker = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Batal")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                    showModeToggle = false
                )
            }
        }
    }
}

fun convertMillisToIndoDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("id", "ID"))
    return formatter.format(Date(millis))
}

