package uz.abbos.dilmurodjonov.todoapp.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.TodoItemsRepository
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoItem

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TodoItemsRepository(application)

    fun getAll() = repository.getToDoList()


    fun getById(id: Long) = repository.getById(id)

    fun insert(data: ToDoItem) = viewModelScope.launch {
        println(Thread.currentThread().name)
        repository.insertToDo(data)
    }

    fun update(data: ToDoItem) = viewModelScope.launch {
        println(Thread.currentThread().name)
        repository.updateToDo(data) }
}