package uz.abbos.dilmurodjonov.todoapp.domain.entities

import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority
import java.util.*

internal data class Task(
    val id: Long = 0,
    val text: String,
    val priority: TaskPriority,
    val deadline: Date? = null,
    val isDone: Boolean = false,
    val createdDate: Date,
    val updatedDate: Date? = null
)
