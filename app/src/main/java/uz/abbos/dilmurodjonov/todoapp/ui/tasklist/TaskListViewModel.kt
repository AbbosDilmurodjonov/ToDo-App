package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.liveData
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import uz.abbos.dilmurodjonov.todoapp.App
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskListUseCase

class TaskListViewModel(
    private val getTaskListUseCase: GetTaskListUseCase,
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getTaskListUseCase = (this[APPLICATION_KEY] as App).getTaskListUseCase
                TaskListViewModel(getTaskListUseCase)
            }
        }
    }

    fun getTaskList() = liveData {
        getTaskListUseCase.invoke().also {
            if (it.isSuccess) emit(it.getOrDefault(emptyList()))
        }
    }

}