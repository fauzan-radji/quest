package com.fauzan.quest.ui.screen.home

import androidx.lifecycle.ViewModel
import com.fauzan.quest.data.Repository
import com.fauzan.quest.data.model.BaseTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(repository: Repository) : ViewModel() {
    private val _tasks: MutableStateFlow<List<BaseTask>> = MutableStateFlow(
        repository.getTasks()
    )
    val tasks = _tasks.asStateFlow()
}