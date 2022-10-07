package uz.abbos.dilmurodjonov.todoapp.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo_list")
data class ToDoItem(
    @PrimaryKey (autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "priority") val priority: String, // low, normal, high
    @ColumnInfo(name = "deadline") val deadline: String? = null,
    @ColumnInfo(name = "is_done") val isDone: Int = 0,
    @ColumnInfo(name = "created_date") val createdDate: String,
    @ColumnInfo(name = "updated_date") val updatedDate: String? = null
)