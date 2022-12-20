package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskListUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskStatusUseCase

class TaskListViewModel(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
) : ViewModel() {

    fun getTaskList() = liveData {
        getTaskListUseCase.invoke().also {
            if (it.isSuccess) emit(it.getOrDefault(emptyList()))
        }
    }

    fun updateTask(taskId: Long, checked: Boolean) {
        viewModelScope.launch {
            updateTaskStatusUseCase.invoke(taskId, checked)
        }
    }

}