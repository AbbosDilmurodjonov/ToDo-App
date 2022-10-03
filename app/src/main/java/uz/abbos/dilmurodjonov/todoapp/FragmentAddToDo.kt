package uz.abbos.dilmurodjonov.todoapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import java.util.*

class FragmentAddToDo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_todo, container, false)

        val priorities = listOf("Low", "Normal", "High")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, priorities)
        val spinner = view.findViewById<Spinner>(R.id.spinner_priority)
        spinner.adapter = adapter

        val dateBtn = view.findViewById<Button>(R.id.btn_date)
        dateBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { dialog, y, m, d ->

            }, year, month, day).show()
        }

        return view
    }
}