package uz.abbos.dilmurodjonov.todoapp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel
import uz.abbos.dilmurodjonov.todoapp.databinding.ItemTaskBinding
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.diffcallbacks.TaskListDiffCallback
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.holders.TaskViewHolder

class TaskListAdapter(private val action: (Long) -> Unit) :
    ListAdapter<Task, TaskViewHolder>(
        AsyncDifferConfig.Builder(TaskListDiffCallback()).build()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)

        return TaskViewHolder(binding, action)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        onBindViewHolder(holder, position, emptyList())
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int,
        payloads: List<Any>
    ) {
        val item = getItem(position)

        if (payloads.isEmpty() || payloads[0] !is Bundle) {
            holder.bind(item)
        } else {
            val bundle = payloads[0] as Bundle
            holder.update(bundle)
        }
    }

    override fun getItemCount() = currentList.size

}