package uz.abbos.dilmurodjonov.todoapp.domain.usecases

import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository
import javax.inject.Inject

class UpdateTaskStatusUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend fun invoke(id: Long, checked: Boolean): Result<Task> {
        return taskRepository.updateTaskStatus(id, checked)
    }
}