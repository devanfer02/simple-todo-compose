package com.example.kotlin_mobile.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier
){
    var todoState = remember {
        mutableStateOf("")
    }

    var todosState = remember {
        mutableStateOf(listOf<Todo>())
    }

    Column(
        modifier = modifier
            .padding(
                horizontal = 10.dp,
                vertical = 12.dp
            )
    ) {
        TodoInput(
            todoState = todoState,
            todosState = todosState,
            modifier = Modifier
                .fillMaxWidth()
        )
        TodoList(
            todos = todosState.value
        )
    }
}