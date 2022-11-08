package uz.abbos.dilmurodjonov.todoapp._old.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp._old.TodoItemsRepository
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TodoItemsRepository(application)

    fun getAll() = repository.getToDoList()


    fun getById(id: Long) = repository.getById(id)

    fun insert(data: TasksEntityModel) = viewModelScope.launch {
        println(Thread.currentThread().name)
        repository.insertToDo(data)
    }

    fun update(data: TasksEntityModel) = viewModelScope.launch {
        println(Thread.currentThread().name)
        repository.updateToDo(data) }
}