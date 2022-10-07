package uz.abbos.dilmurodjonov.todoapp.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uz.abbos.dilmurodjonov.todoapp.TodoItemsRepository
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoItem

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TodoItemsRepository(application)

    fun getAll() = repository.getToDoList()

    fun insert(data: ToDoItem) = repository.insertToDo(data)


}