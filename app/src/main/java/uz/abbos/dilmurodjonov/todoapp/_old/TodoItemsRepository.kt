package uz.abbos.dilmurodjonov.todoapp._old

import android.content.Context
import kotlinx.coroutines.flow.Flow
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel

class TodoItemsRepository(private val context: Context) {
    private val executor = SerialExecutor()

    private val dao
        get(): TasksDao = AppDatabase.instance(context).todoDao()

    fun getToDoList(): Flow<List<TasksEntityModel>> = dao.getAll()
    fun getById(id: Long): Flow<TasksEntityModel?> = dao.getOneById(id)


    suspend fun insertToDo(data: TasksEntityModel) {
        dao.insert(data)
    }

    suspend fun updateToDo(data: TasksEntityModel) {
        dao.update(data)
    }

    suspend fun deleteToDo(data: TasksEntityModel) {
        dao.delete(data)
    }

}