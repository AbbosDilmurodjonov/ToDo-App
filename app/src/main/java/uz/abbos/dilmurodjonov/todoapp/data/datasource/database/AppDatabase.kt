package uz.abbos.dilmurodjonov.todoapp.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel

@Database(
    entities = [TasksEntityModel::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
 abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TasksDao
}