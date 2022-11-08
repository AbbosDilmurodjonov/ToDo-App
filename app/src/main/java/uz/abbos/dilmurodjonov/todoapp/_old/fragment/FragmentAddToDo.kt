package uz.abbos.dilmurodjonov.todoapp._old.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.abbos.dilmurodjonov.todoapp.databinding.FragmentAddTodoBinding
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class FragmentAddToDo : Fragment() {
    private val args: uz.abbos.dilmurodjonov.todoapp.fragment.FragmentAddToDoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val itemId = args.toDoId
        var itemCreatedDate = ""

        val viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        val binding = FragmentAddTodoBinding.inflate(inflater, container, false)

        val priorities = listOf("Low", "Normal", "High")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, priorities)
        val spinner = binding.spinnerPriority
        spinner.adapter = adapter
        var priorityText = priorities[0]
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                priorityText = priorities[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        val deadline = Calendar.getInstance()
        val sdfDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.btnDate.text = sdfDate.format(deadline.time)

        binding.btnDate.setOnClickListener {
            val year = deadline.get(Calendar.YEAR)
            val month = deadline.get(Calendar.MONTH)
            val day = deadline.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { dialog, y, m, d ->
                deadline.set(Calendar.YEAR, y)
                deadline.set(Calendar.MONTH, m)
                deadline.set(Calendar.DAY_OF_MONTH, d)

                binding.btnDate.text = sdfDate.format(deadline.time)
            }, year, month, day).show()
        }

        binding.btnCancel.setOnClickListener { findNavController().navigateUp() }
        binding.btnSave.setOnClickListener {
            var text = ""
            binding.editText.text?.toString()?.let {
                text = it
            }

            val sdfDateTime = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val createdDate = sdfDateTime.format(Calendar.getInstance().time)

            if (itemId > 0) {
                val data = TasksEntityModel(
                    id = itemId,
                    text = text,
                    priority = priorityText,
                    deadline = sdfDate.format(deadline.time),
                    isDone = 0,
                    createdDate = itemCreatedDate,
                    updatedDate = createdDate
                )
                viewModel.update(data)

            } else {
                val data = TasksEntityModel(
                    text = text,
                    priority = priorityText,
                    deadline = sdfDate.format(deadline.time),
                    isDone = 0,
                    createdDate = createdDate,
                )
                viewModel.insert(data)
            }

            findNavController().navigateUp()
        }



        if (itemId > 0) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.getById(itemId).collect { toDoItem ->
                    toDoItem?.let {
                        itemCreatedDate = it.createdDate
                        binding.editText.setText(it.text)
                        binding.spinnerPriority.setSelection(priorities.indexOf(it.priority))
                        it.deadline?.let { date ->
                            try {
                                val time = sdfDate.parse(date)
                                deadline.time = time
                                binding.btnDate.text = date
                            } catch (e: ParseException) {
                                // ignore exception
                            }

                        }
                    }
                }
            }
        }

        return binding.root
    }
}