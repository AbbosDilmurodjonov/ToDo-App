package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.abbos.dilmurodjonov.todoapp.di.scope.FeatureTaskListScope
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskListUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskStatusUseCase
import javax.inject.Inject

@FeatureTaskListScope
class TaskListViewModelFactory @Inject constructor(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == TaskListViewModel::class.java)
        return TaskListViewModel(getTaskListUseCase, updateTaskStatusUseCase) as T
    }
}