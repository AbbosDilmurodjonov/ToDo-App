package uz.abbos.dilmurodjonov.todoapp

class TodoItemsRepository {

    fun getToDoList(): List<ToDoItem> {
        val item = ToDoItem(
            id = "00",
            text = "Title",
            priority = "Low",
            isDone = 0,
            createdDate = "2022-10-03 14:36"
        )

        val list = mutableListOf(item)

        for (i in 0 until 20) {
            list.add(item)
        }

        return list
    }

    fun insertToDo(data: ToDoItem) {

    }


}