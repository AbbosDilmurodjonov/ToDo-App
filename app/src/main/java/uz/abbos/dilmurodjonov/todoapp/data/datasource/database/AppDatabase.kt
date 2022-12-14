package uz.abbos.dilmurodjonov.todoapp.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    abstract fun todoDao(): TasksDao

    companion object {
        private const val DATABASE_NAME = "database-name"
        private var database: AppDatabase? = null

        fun instance(context: Context): AppDatabase {
            if (database == null) {
                synchronized(this) {
                    database = databaseBuilder(context)
                }
            }

            return database!!
        }

        private fun databaseBuilder(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build()
        }

        private val roomCallback: Callback = object : Callback() {
            // some actions
        }
    }
}