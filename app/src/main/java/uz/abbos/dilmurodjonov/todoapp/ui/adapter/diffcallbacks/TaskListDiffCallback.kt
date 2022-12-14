package uz.abbos.dilmurodjonov.todoapp.ui.adapter.diffcallbacks

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task

const val ARG_TASK_DONE = "task.arg.done"

class TaskListDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Task, newItem: Task) =
        oldItem == newItem

    override fun getChangePayload(oldItem: Task, newItem: Task): Any? {
        if (oldItem.id != newItem.id || oldItem.isDone == newItem.isDone) {
            return super.getChangePayload(oldItem, newItem)
        }

        val diff = Bundle()
        diff.putBoolean(ARG_TASK_DONE, newItem.isDone)
        return diff
    }
}