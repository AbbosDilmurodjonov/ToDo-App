package uz.abbos.dilmurodjonov.todoapp.storage

import androidx.room.*

@Dao
interface ToDoDao {

    @Query("SELECT * FROM TODO_LIST")
    fun all(): List<ToDoItem>

    @Insert
    fun insert(item: ToDoItem)

    @Update
    fun update(item: ToDoItem)

    @Delete
    fun delete(item: ToDoItem)
}