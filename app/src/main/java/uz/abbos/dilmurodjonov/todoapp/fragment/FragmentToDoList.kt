package uz.abbos.dilmurodjonov.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import uz.abbos.dilmurodjonov.todoapp.R
import uz.abbos.dilmurodjonov.todoapp.ToDoAdapter
import uz.abbos.dilmurodjonov.todoapp.databinding.FragmentTodoListBinding

class FragmentToDoList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        val binding = FragmentTodoListBinding.inflate(inflater, container, false)

        val adapter = ToDoAdapter()

        val recycler = binding.recycler
        recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getAll().collect{
                adapter.list = it
            }
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentToDoList_to_fragmentAddToDo)
        }

        return binding.root
    }
}