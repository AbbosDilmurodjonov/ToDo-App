package uz.abbos.dilmurodjonov.todoapp.ui.taskdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.abbos.dilmurodjonov.todoapp.di.scope.FeatureTaskDetailsScope
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.AddTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.DeleteTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskUseCase
import javax.inject.Inject

@FeatureTaskDetailsScope
class TaskDetailViewModelFactory @Inject constructor(
    private val getTaskUseCase: GetTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == TaskDetailViewModel::class.java)
        return TaskDetailViewModel(
            getTaskUseCase,
            addTaskUseCase,
            updateTaskUseCase,
            deleteTaskUseCase
        ) as T
    }
}