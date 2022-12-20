package uz.abbos.dilmurodjonov.todoapp.ui.taskdetail

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import uz.abbos.dilmurodjonov.todoapp.appComponent
import uz.abbos.dilmurodjonov.todoapp.databinding.FragmentTaskDetailBinding
import java.util.*
import javax.inject.Inject

class TaskDetailFragment : Fragment() {
    private val viewModel: TaskDetailViewModel by viewModels { factory.get() }
    private val args: TaskDetailFragmentArgs by navArgs()
    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: dagger.Lazy<TaskDetailViewModelFactory>
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.featureTaskDetailsComponent()
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        this._binding = binding

        viewModel.taskId = args.taskId
        configureBackBtn()
        configureDeadlineBtn()
        configureDeleteBtn()
        configureSaveBtn()
        configurePrioritySpinner()

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getTask()
            refreshContent()
        }

        return binding.root
    }

    private fun refreshContent() {
        binding.editText.setText(viewModel.taskContent)
        binding.spinnerPriority.setSelection(viewModel.taskPriorityPosition)
        binding.buttonDeadline.text = viewModel.taskDeadlineText
    }

    private fun configurePrioritySpinner() {
        val priorities = viewModel.prioritiesText

        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, priorities)

        binding.spinnerPriority.adapter = adapter
        binding.spinnerPriority.selected { viewModel.taskPriorityPosition = it }
    }

    private fun configureDeadlineBtn() {
        binding.buttonDeadline.text = viewModel.taskDeadlineText

        binding.buttonDeadline.setOnClickListener {
            val year = viewModel.taskDeadline.get(Calendar.YEAR)
            val month = viewModel.taskDeadline.get(Calendar.MONTH)
            val day = viewModel.taskDeadline.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, y, m, d ->
                val deadlineText = viewModel.setTaskDeadline(y, m, d)
                binding.buttonDeadline.text = deadlineText
            }, year, month, day).show()
        }
    }

    private fun configureBackBtn() {
        binding.btnCancel.setOnClickListener { onBack() }
    }

    private fun configureSaveBtn() {
        binding.btnSave.setOnClickListener {
            binding.editText.text?.toString()?.let {
                viewModel.taskContent = it
            }

            lifecycleScope.launch {
                viewModel.saveTask()
                onBack()
            }
        }
    }

    private fun configureDeleteBtn() {
        binding.btnDelete.setOnClickListener {
            lifecycleScope.launch {
                viewModel.deleteTask()
                onBack()
            }
        }
    }

    private fun onBack() {
        findNavController().navigateUp()
    }
}