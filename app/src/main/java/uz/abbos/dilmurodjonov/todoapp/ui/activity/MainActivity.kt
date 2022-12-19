package uz.abbos.dilmurodjonov.todoapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.abbos.dilmurodjonov.todoapp.App
import uz.abbos.dilmurodjonov.todoapp.R
import uz.abbos.dilmurodjonov.todoapp.di.TaskComponent

class MainActivity : AppCompatActivity() {
    lateinit var taskComponent: TaskComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        taskComponent = App.get(applicationContext).appComponent.taskComponent().create()
        taskComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}