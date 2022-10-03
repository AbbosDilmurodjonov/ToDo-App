package uz.abbos.dilmurodjonov.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentToDoList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)
        val rep = TodoItemsRepository()
        val adapter = ToDoAdapter(rep.getToDoList())
        // adapter.notifyDataSetChanged()

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentToDoList_to_fragmentAddToDo)
        }
        return view
    }
}