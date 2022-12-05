package uz.abbos.dilmurodjonov.todoapp.ui.taskdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.AddTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.DeleteTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskUseCase

internal class TaskDetailViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {

    fun getTask(id: Long): LiveData<Task> {
        return liveData {
            getTaskUseCase.invoke(id).also {
                if (it.isSuccess) it.getOrThrow()
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase.invoke(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase.invoke(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.invoke(task.id)
        }
    }
}