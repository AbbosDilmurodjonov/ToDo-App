package uz.abbos.dilmurodjonov.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.abbos.dilmurodjonov.todoapp.storage.ToDoItem

class ToDoAdapter :
    RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {

    var list: List<ToDoItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ToDoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flag: CheckBox = itemView.findViewById(R.id.checkbox)
        private val text: TextView = itemView.findViewById(R.id.text_title)

        fun bind(item: ToDoItem) {
            flag.isChecked = item.isDone == 0
            text.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_todo, parent, false)

        return ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        if (list == null) return
        holder.bind(list!![position])
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}