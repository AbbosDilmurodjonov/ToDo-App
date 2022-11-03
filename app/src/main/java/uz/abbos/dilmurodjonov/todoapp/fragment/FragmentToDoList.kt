package uz.abbos.dilmurodjonov.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.R
import uz.abbos.dilmurodjonov.todoapp.ToDoAdapter
import uz.abbos.dilmurodjonov.todoapp.databinding.FragmentTodoListBinding

class FragmentToDoList : Fragment() {

    private var viewModel: ToDoViewModel? = null
    private var adapter: ToDoAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        val binding = FragmentTodoListBinding.inflate(inflater, container, false)

        adapter = ToDoAdapter { item ->
            val action = FragmentToDoListDirections.actionFragmentToDoListToFragmentAddToDo()
            action.toDoId = item
            findNavController().navigate(action)
        }

        val recycler = binding.recycler
        recycler.adapter = adapter



        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentToDoList_to_fragmentAddToDo)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel?.getAll()
                ?.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                ?.collect {
                    adapter?.submitList(it)
                }

        }
    }
}