package com.example.kotlin_mobile.todo

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class Todo(
    val task: String,
    done: Boolean
) {
    var done by mutableStateOf(done)
}