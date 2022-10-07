package uz.abbos.dilmurodjonov.todoapp

import android.content.Context
import kotlinx.coroutines.flow.Flow
import uz.abbos.dilmurodjonov.todoapp.storage.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoDao
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoItem

class TodoItemsRepository(private val context: Context) {
    private val executor = SerialExecutor()

    private val dao
        get(): ToDoDao = AppDatabase.instance(context).todoDao()

    fun getToDoList(): Flow<List<ToDoItem>> = dao.all()


    fun insertToDo(data: ToDoItem) {
        executor.execute { dao.insert(data) }
    }

    fun updateToDo(data: ToDoItem) {
        executor.execute { dao.update(data) }
    }

    fun deleteToDo(data: ToDoItem) {
        executor.execute { dao.delete(data) }
    }

}