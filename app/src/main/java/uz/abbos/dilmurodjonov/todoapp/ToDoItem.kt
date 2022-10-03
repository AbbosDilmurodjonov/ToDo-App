package uz.abbos.dilmurodjonov.todoapp

data class ToDoItem(
    val id: String,
    val text: String,
    val priority: String, // low, normal, high
    val deadline: String? = null,
    val isDone: Int = 0,
    val createdDate: String,
    val updatedDate: String? = null
)