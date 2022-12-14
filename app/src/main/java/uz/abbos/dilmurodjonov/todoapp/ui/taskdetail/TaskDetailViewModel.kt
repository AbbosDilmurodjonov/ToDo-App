package uz.abbos.dilmurodjonov.todoapp.ui.taskdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.App
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority.*
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.AddTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.DeleteTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.GetTaskUseCase
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.UpdateTaskUseCase
import java.text.SimpleDateFormat
import java.util.*

class TaskDetailViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {

    private val priorities = listOf(LOW, BASIC, IMPORTANT)
    private val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    private var taskCreatedDate = Date()
    var taskId: Long = 0L
    var taskContent: String = ""
    var taskDeadline: Calendar = Calendar.getInstance()
        private set

    val prioritiesText get() = priorities.map { it.name }
    val taskDeadlineText: String get() = sdf.format(taskDeadline.time)
    var taskPriorityPosition: Int = 0

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as App

                val getTaskUseCase = app.getTaskUseCase
                val addTaskUseCase = app.addTaskUseCase
                val updateTaskUseCase = app.updateTaskUseCase
                val deleteTaskUseCase = app.deleteTaskUseCase

                TaskDetailViewModel(
                    getTaskUseCase,
                    addTaskUseCase,
                    updateTaskUseCase,
                    deleteTaskUseCase
                )
            }
        }
    }

    fun setTaskDeadline(year: Int, month: Int, day: Int): String {
        taskDeadline.set(Calendar.YEAR, year)
        taskDeadline.set(Calendar.MONTH, month)
        taskDeadline.set(Calendar.DAY_OF_MONTH, day)

        return taskDeadlineText
    }

    fun saveTask() {
        if (taskId > 0) {
            val task = Task(
                id = taskId,
                text = taskContent,
                priority = priorities[taskPriorityPosition],
                deadline = taskDeadline.time,
                isDone = false,
                createdDate = taskCreatedDate,
                updatedDate = Date()
            )

            updateTask(task)
        } else {
            val task = Task(
                text = taskContent,
                priority = priorities[taskPriorityPosition],
                deadline = taskDeadline.time,
                isDone = false,
                createdDate = Date(),
            )

            addTask(task)
        }
    }

    suspend fun getTask() {
        if (taskId <= 0) return

        getTaskUseCase.invoke(taskId).also {
            if (it.isSuccess) {
                val task = it.getOrThrow()

                taskCreatedDate = task.createdDate
                taskContent = task.text
                taskPriorityPosition = priorities.indexOf(task.priority)
                task.deadline?.let { date ->
                    taskDeadline.time = date
                }
            }
        }
    }

    private fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase.invoke(task)
        }
    }

    private fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase.invoke(task)
        }
    }

    private fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.invoke(task.id)
        }
    }
}