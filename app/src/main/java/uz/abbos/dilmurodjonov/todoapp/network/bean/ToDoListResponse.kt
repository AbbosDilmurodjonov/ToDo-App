package uz.abbos.dilmurodjonov.todoapp.network.bean

data class ToDoListResponse(
    val status:String,
    val list: List<ToDo>
)