package com.example.kotlin_mobile.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoList(
    todos: List<Todo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {

        items(todos) { current ->
            TodoItem(
                todo = current
            )
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo
) {
    var checked by remember {
        mutableStateOf(todo.done)
    }

    Row(
        modifier = Modifier
            .padding(
                vertical = 10.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.done,
            onCheckedChange = { isChecked ->
                checked = isChecked
                todo.done = isChecked
            }
        )
        Text(
            text = "${todo.task}",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 20.sp,
            style = if(todo.done) {
                TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            } else {
                TextStyle(
                    textDecoration = TextDecoration.None
                )
            }
        )

    }
    HorizontalDivider()
}