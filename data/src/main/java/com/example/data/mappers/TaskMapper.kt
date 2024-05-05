package com.example.data.mappers

import com.example.data.models.DTask
import com.example.domain.models.Task

fun Task.toDTask() = DTask(id, title, description, priority)
fun DTask.toTask() = Task(id, title, description, priority)