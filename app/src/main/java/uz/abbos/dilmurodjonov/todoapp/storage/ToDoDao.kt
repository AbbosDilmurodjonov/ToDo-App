package uz.abbos.dilmurodjonov.todoapp.storage

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM TODO_LIST")
    fun all(): Flow<List<ToDoItem>>

    @Query("SELECT * FROM TODO_LIST WHERE ID = :id")
    fun byId(id: Long): Flow<ToDoItem?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ToDoItem)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(item: ToDoItem)

    @Delete
    suspend fun delete(item: ToDoItem)
}