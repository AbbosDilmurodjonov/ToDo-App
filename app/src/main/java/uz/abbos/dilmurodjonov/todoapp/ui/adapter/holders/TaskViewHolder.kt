package uz.abbos.dilmurodjonov.todoapp.ui.adapter.holders

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import uz.abbos.dilmurodjonov.todoapp.databinding.ItemTaskBinding
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.diffcallbacks.ARG_TASK_DONE

class TaskViewHolder(private val binding: ItemTaskBinding, private val action: (Long) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Task) {
        binding.root.setOnClickListener { action.invoke(item.id) }

        binding.checkboxDone.isChecked = item.isDone
        binding.textTaskTitle.text = item.text
    }

    fun update(bundle: Bundle) {
        if (bundle.containsKey(ARG_TASK_DONE)) {
            val checked = bundle.getBoolean(ARG_TASK_DONE)
            binding.checkboxDone.isChecked = checked
        }
    }

}