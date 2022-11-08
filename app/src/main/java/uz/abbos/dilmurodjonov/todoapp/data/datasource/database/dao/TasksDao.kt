package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel

@Dao
internal interface TasksDao {

    @Query("SELECT * FROM TASKS")
    fun getAll(): Flow<List<TasksEntityModel>>

    @Query("SELECT * FROM TASKS WHERE ID = :id")
    fun getOneById(id: Long): Flow<TasksEntityModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg tasks: TasksEntityModel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(vararg tasks: TasksEntityModel)

    @Delete
    suspend fun delete(vararg tasks: TasksEntityModel)
}