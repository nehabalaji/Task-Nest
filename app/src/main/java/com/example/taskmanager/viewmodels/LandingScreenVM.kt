package com.example.taskmanager.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.constants.PriorityLevel
import com.example.domain.models.Task
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.ReadTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingScreenVM @Inject constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val readTaskUseCase: ReadTaskUseCase
): ViewModel(){

    private val _taskList = MutableStateFlow<Flow<List<Task>>>(emptyFlow())
    var taskList = _taskList.asStateFlow()

    init {
        insertTaskIntoDB(Task(title = "Test1", description = "Test Task", priority = PriorityLevel.MEDIUM))
        insertTaskIntoDB(Task(title = "Test2", description = "Test Task", priority = PriorityLevel.HIGH))
        insertTaskIntoDB(Task(title = "Test3", description = "Test Task", priority = PriorityLevel.LOW))
        insertTaskIntoDB(Task(title = "Test4", description = "Test Task", priority = PriorityLevel.HIGH))
        fetchTasks()
    }

    private fun fetchTasks() = viewModelScope.launch {
        _taskList.value = readTaskUseCase()
    }
    fun insertTaskIntoDB(task: Task) {
        viewModelScope.launch {
            createTaskUseCase(task)
        }
    }
}