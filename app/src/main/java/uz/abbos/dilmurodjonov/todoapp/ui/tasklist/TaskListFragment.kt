package uz.abbos.dilmurodjonov.todoapp.ui.tasklist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import uz.abbos.dilmurodjonov.todoapp.appComponent
import uz.abbos.dilmurodjonov.todoapp.databinding.FragmentTaskListBinding
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.TaskListAdapter
import javax.inject.Inject

class TaskListFragment : Fragment() {

    private val viewModel: TaskListViewModel by viewModels { factory.get() }

    @Inject
    lateinit var factory: dagger.Lazy<TaskListViewModelFactory>

    private val adapter: TaskListAdapter by lazy {
        TaskListAdapter(
            this::navigateToDetails,
            viewModel::updateTask
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent
            .featureTaskListComponent()
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTaskListBinding.inflate(inflater, container, false)
        binding.recyclerTasks.adapter = adapter

        binding.fabAdd.setOnClickListener {
            navigateToDetails()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getTaskList().observe(viewLifecycleOwner) {
                Log.d(TaskListFragment::class.simpleName, "onViewCreated: " + it.size)
                adapter.submitList(it.toMutableList())
            }
        }
    }


    private fun navigateToDetails(id: Long? = null) {
        val direction = TaskListFragmentDirections.actionFragmentTaskListToFragmentTaskDetail()
        id?.let {
            direction.taskId = id
        }

        findNavController().navigate(direction)
    }
}