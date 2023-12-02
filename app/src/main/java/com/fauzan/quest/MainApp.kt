package com.fauzan.quest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun MainApp(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello ${stringResource(id = R.string.app_name)}",
        modifier = modifier
    )
}