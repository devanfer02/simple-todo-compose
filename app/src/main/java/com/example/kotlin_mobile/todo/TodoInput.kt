package com.example.kotlin_mobile.todo

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoInput(
    todoState: MutableState<String>,
    todosState: MutableState<List<Todo>>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = todoState.value,
            modifier = Modifier
                .height(50.dp)
                .weight(1f),
            onValueChange = { text: String ->
                todoState.value = text
            },
            shape = RoundedCornerShape(6.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        OutlinedButton(
            onClick = {
                if (todoState.value.isNotBlank()) {
                    todosState.value += listOf(
                        Todo(
                            task = todoState.value,
                            done = false
                        )
                    )
                    todoState.value = ""
                }
            },
            border = BorderStroke(1.dp, Color.Blue),
            modifier = Modifier
                ,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Add",
                color = Color.Blue,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),

                )
        }
        Spacer(modifier = Modifier.width(5.dp))
        OutlinedButton(
            onClick = {
                val filtered = todosState.value.filter { todo ->
                    !todo.done
                }

                todosState.value = filtered
            },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Clear",
                color = Color.Red,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),
                )
        }
    }
}
