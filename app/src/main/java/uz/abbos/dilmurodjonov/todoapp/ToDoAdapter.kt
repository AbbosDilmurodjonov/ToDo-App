package uz.abbos.dilmurodjonov.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.abbos.dilmurodjonov.todoapp.databinding.ItemTodoBinding
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoItem

class ToDoAdapter :
    ListAdapter<ToDoItem, ToDoAdapter.ItemToDoHolder>(
        AsyncDifferConfig.Builder(DiffCallback()).build()
    ) {

    companion object {
        private const val ARG_DONE = "arg.done"
    }

    private class DiffCallback : DiffUtil.ItemCallback<ToDoItem>() {
        override fun areItemsTheSame(oldItem: ToDoItem, newItem: ToDoItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ToDoItem, newItem: ToDoItem) =
            oldItem == newItem

        override fun getChangePayload(oldItem: ToDoItem, newItem: ToDoItem): Any? {
            if (oldItem.id == newItem.id) {
                return if (oldItem.isDone == newItem.isDone) {
                    super.getChangePayload(oldItem, newItem)
                } else {
                    val diff = Bundle()
                    diff.putBoolean(ARG_DONE, newItem.isDone == 1)
                    diff
                }
            }

            return super.getChangePayload(oldItem, newItem)
        }
    }

    class ItemToDoHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ToDoItem) {
            binding.checkbox.isChecked = item.isDone == 1
            binding.textTitle.text = item.text
        }

        fun update(bundle: Bundle) {
            if (bundle.containsKey(ARG_DONE)) {
                val checked = bundle.getBoolean(ARG_DONE)
                binding.checkbox.isChecked = checked
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemToDoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(inflater, parent, false)

        return ItemToDoHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemToDoHolder, position: Int) {
        onBindViewHolder(holder, position, emptyList())
    }

    override fun onBindViewHolder(
        holder: ItemToDoHolder,
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

    override fun getItemCount(): Int {
        return currentList.size
    }


}