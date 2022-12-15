package uz.abbos.dilmurodjonov.todoapp.ui.adapter.holders

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import uz.abbos.dilmurodjonov.todoapp.databinding.ItemTaskBinding
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.diffcallbacks.ARG_TASK_DONE

class TaskViewHolder(
    private val binding: ItemTaskBinding,
    private val showDetails: (id: Long) -> Unit,
    private val updateContent: (id: Long, checked: Boolean) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Task) {
        binding.root.setOnClickListener { showDetails.invoke(item.id) }
        binding.checkboxDone.setOnCheckedChangeListener { _, isChecked ->
            updateContent.invoke(
                item.id,
                isChecked
            )
        }

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