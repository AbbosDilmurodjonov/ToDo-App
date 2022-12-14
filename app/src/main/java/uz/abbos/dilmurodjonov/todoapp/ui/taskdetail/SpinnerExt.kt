package uz.abbos.dilmurodjonov.todoapp.ui.taskdetail

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

fun Spinner.selected(action: (position: Int) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            action(position)
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}