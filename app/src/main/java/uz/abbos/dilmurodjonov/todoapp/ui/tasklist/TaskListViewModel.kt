package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.App
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskListUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskStatusUseCase

class TaskListViewModel(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as App
                val getTaskListUseCase = application.getTaskListUseCase
                val updateTaskStatusUseCase = application.updateTaskStatusUseCase
                TaskListViewModel(getTaskListUseCase, updateTaskStatusUseCase)
            }
        }
    }

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