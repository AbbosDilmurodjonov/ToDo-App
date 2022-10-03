package uz.abbos.dilmurodjonov.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        var fragment = manager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = FragmentToDoList()

            manager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }

    }
}