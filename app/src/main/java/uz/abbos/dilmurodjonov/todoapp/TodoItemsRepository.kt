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
    fun getById(id: Long): Flow<ToDoItem?> = dao.byId(id)


    suspend fun insertToDo(data: ToDoItem) {
        dao.insert(data)
    }

    suspend fun updateToDo(data: ToDoItem) {
        dao.update(data)
    }

    suspend fun deleteToDo(data: ToDoItem) {
        dao.delete(data)
    }

}