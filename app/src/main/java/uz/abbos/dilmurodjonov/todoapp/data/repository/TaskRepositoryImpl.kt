package uz.abbos.dilmurodjonov.todoapp.data.repository

import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.toDomainModel
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.exceptions.NotFoundException
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository

internal class TaskRepositoryImpl(
    private val tasksService: TasksService,
    private val tasksDao: TasksDao,
) : TaskRepository {

    override suspend fun getTaskList(): Result<List<Task>> {
        val tasks = tasksDao.getAll()
            .map {
                it.toDomainModel()
            }

        return Result.success(tasks)
    }

    override suspend fun getTask(id: Long): Result<Task> {
        val task = tasksDao.getOneById(id)?.toDomainModel()
            ?: return Result.failure(NotFoundException())

        return Result.success(task)
    }

    override suspend fun addTask(task: Task): Result<Task> {
        val model = TasksEntityModel.fromDomainModel(task)
        val id = tasksDao.insert(model)

        val result = tasksDao.getOneById(id)
            ?: return Result.failure(NotFoundException())

        return Result.success(result.toDomainModel())
    }

    override suspend fun updateTask(task: Task): Result<Task> {
        val model = TasksEntityModel.fromDomainModel(task)
        tasksDao.update(model)
        val id = model.id

        val result = tasksDao.getOneById(id)
            ?: return Result.failure(NotFoundException())

        return Result.success(result.toDomainModel())
    }

    override suspend fun deleteTask(id: Long): Result<Task> {
        val model = tasksDao.getOneById(id)
            ?: return Result.failure(NotFoundException())

        tasksDao.delete(model)

        return Result.success(model.toDomainModel())
    }
}