package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskListUseCase

internal class TaskListViewModel(
    private val getTaskListUseCase: GetTaskListUseCase,
) : ViewModel() {

    fun getTaskList(): LiveData<List<Task>> {
        return liveData {
            getTaskListUseCase.invoke().also {
                if (it.isSuccess) it.getOrThrow()
            }
        }
    }
}