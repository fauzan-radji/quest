package com.fauzan.quest.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fauzan.quest.data.model.BaseTask
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.di.Injection
import com.fauzan.quest.ui.ViewModelFactory
import com.fauzan.quest.ui.component.TaskCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(repository = Injection.provideRepository())
    )
) {
    val tasks by viewModel.tasks.collectAsState()

    HomeContent(
        tasks = tasks,
        modifier = modifier,
        onTaskClick = { }
    )
}

@Composable
fun HomeContent(
    tasks: List<BaseTask>,
    onTaskClick: (BaseTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(tasks, key = { it.getId() }) { task ->
            when(task) {
                is OneTimeTask -> TaskCard(
                    task = task,
                    onClick = onTaskClick,
                    modifier = Modifier.fillParentMaxWidth()
                )
                is RepeatingTask -> TaskCard(
                    task = task,
                    onClick = onTaskClick,
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
    }
}