package com.example.data.mappers

import com.example.data.models.DTask
import com.example.domain.models.Task

fun Task.toDTask() = DTask(id, title, description, users, priority)
fun DTask.toTask() = Task(id, title, description, users, priority)