package uz.abbos.dilmurodjonov.todoapp.domain.repository

import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task

interface TaskRepository {

    suspend fun getTaskList(): Result<List<Task>>

    suspend fun getTask(id: Long): Result<Task>

    suspend fun addTask(task: Task): Result<Task>

    suspend fun updateTask(task: Task): Result<Task>

    suspend fun updateTaskStatus(id: Long, checked: Boolean): Result<Task>

    suspend fun deleteTask(id: Long): Result<Task>
}