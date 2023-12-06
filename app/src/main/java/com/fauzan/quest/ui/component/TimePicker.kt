package com.fauzan.quest.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import java.time.LocalTime

@Composable
fun TimePicker(
    state: MaterialDialogState,
    onValueChange: (LocalTime) -> Unit
) {
    MaterialDialog(
        dialogState = state,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        timepicker(
            initialTime = LocalTime.now(),
            title = "Pick a time",
            is24HourClock= true,
            colors = TimePickerDefaults.colors(
                activeBackgroundColor = MaterialTheme.colorScheme.primary.copy(0.3f),
                inactiveBackgroundColor = MaterialTheme.colorScheme.onBackground.copy(0.3f),
                activeTextColor = MaterialTheme.colorScheme.onPrimary,
                inactiveTextColor = MaterialTheme.colorScheme.onBackground,
                inactivePeriodBackground = Color.Transparent,
                selectorColor = MaterialTheme.colorScheme.primary,
                selectorTextColor = MaterialTheme.colorScheme.onPrimary,
                headerTextColor = MaterialTheme.colorScheme.onBackground,
                borderColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            onValueChange(it)
        }
    }
}