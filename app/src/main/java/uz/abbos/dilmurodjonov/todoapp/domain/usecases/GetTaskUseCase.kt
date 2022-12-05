package uz.abbos.dilmurodjonov.todoapp.domain.usecases

import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository

internal class GetTaskUseCase(private val taskRepository: TaskRepository) {
    suspend fun invoke(id: Long): Result<Task> {
        return taskRepository.getTask(id);
    }
}