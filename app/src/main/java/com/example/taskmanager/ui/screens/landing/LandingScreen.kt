package com.example.taskmanager.ui.screens.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskmanager.ui.screens.landing.components.TaskCard
import com.example.taskmanager.viewmodels.LandingScreenVM

@Composable
fun LandingScreen(
    landingScreenVM: LandingScreenVM = hiltViewModel()
) {
    val taskListFlow by landingScreenVM.taskList.collectAsState()
    val taskList by taskListFlow.collectAsState(initial = emptyList())
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
       items(taskList) {
           TaskCard(task = it)
       }
    }
}