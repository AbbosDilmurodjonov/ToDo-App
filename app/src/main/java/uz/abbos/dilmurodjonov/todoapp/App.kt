package uz.abbos.dilmurodjonov.todoapp

import android.app.Application
import android.content.Context
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.NetworkService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao
import uz.abbos.dilmurodjonov.todoapp.data.repository.TaskRepositoryImpl
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.*

/**
 * Custom Application class allows to hold reference to [applicationComponent]
 * as long as application lives.
 */
class App : Application() {
    private var _taskService: TasksService? = null
    private var _taskDao: TasksDao? = null
    private var _taskRepository: TaskRepository? = null

    companion object {
        /**
         * Shortcut to get [App] instance from any context, e.g. from Activity.
         */
        fun get(context: Context) = context.applicationContext as App
    }

    val getTaskListUseCase: GetTaskListUseCase get() = GetTaskListUseCase(taskRepository)
    val getTaskUseCase: GetTaskUseCase get() = GetTaskUseCase(taskRepository)
    val addTaskUseCase: AddTaskUseCase get() = AddTaskUseCase(taskRepository)
    val updateTaskUseCase: UpdateTaskUseCase get() = UpdateTaskUseCase(taskRepository)
    val updateTaskStatusUseCase: UpdateTaskStatusUseCase get() = UpdateTaskStatusUseCase(taskRepository)
    val deleteTaskUseCase: DeleteTaskUseCase get() = DeleteTaskUseCase(taskRepository)

    private val taskService
        get():TasksService {
            if (_taskService == null) {
                _taskService = NetworkService(this).taskService
            }
            return _taskService!!
        }

    private val taskDao
        get():TasksDao {
            if (_taskDao == null) {
                _taskDao = AppDatabase.instance(this).todoDao()
            }
            return _taskDao!!
        }

    private val taskRepository
        get():TaskRepository {
            if (_taskRepository == null) {
                _taskRepository = TaskRepositoryImpl(taskService, taskDao)
            }
            return _taskRepository!!
        }
}