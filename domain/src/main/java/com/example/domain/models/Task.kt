package com.example.domain.models

import com.example.domain.constants.PriorityLevel

data class Task(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: PriorityLevel = PriorityLevel.LOW
)
