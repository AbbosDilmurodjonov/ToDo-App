package uz.abbos.dilmurodjonov.todoapp.storage

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM TODO_LIST")
    fun all(): Flow<List<ToDoItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: ToDoItem)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update(item: ToDoItem)

    @Delete
    fun delete(item: ToDoItem)
}