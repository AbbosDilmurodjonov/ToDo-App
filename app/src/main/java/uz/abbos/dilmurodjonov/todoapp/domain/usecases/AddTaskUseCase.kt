package uz.abbos.dilmurodjonov.todoapp.domain.usecases

import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository

internal class AddTaskUseCase(private val taskRepository: TaskRepository) {

    suspend fun invoke(task: Task): Result<Task> {
        return taskRepository.addTask(task)
    }
}