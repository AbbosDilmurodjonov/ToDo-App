package uz.abbos.dilmurodjonov.todoapp.domain.usecases

import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository

internal class GetTaskListUseCase(private val taskRepository: TaskRepository) {

    suspend fun invoke(): Result<List<Task>> {
        return taskRepository.getTaskList()
    }
}