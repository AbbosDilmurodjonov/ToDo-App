package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao

import androidx.room.*
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel

@Dao
 interface TasksDao {

    @Query("SELECT * FROM TASKS")
    suspend fun getAll(): List<TasksEntityModel>

    @Query("SELECT * FROM TASKS WHERE ID = :id")
    suspend fun getOneById(id: Long): TasksEntityModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TasksEntityModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg tasks: TasksEntityModel): LongArray

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(vararg tasks: TasksEntityModel)

    @Delete
    suspend fun delete(vararg tasks: TasksEntityModel)
}