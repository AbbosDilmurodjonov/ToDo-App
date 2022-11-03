package uz.abbos.dilmurodjonov.todoapp.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ToDoItem::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): ToDoDao

    companion object {
        private var database: AppDatabase? = null;

        fun instance(context: Context): AppDatabase {
            if (database == null) {
                synchronized(AppDatabase::class.java) {
                    database = databaseBuilder(context)
                }
            }

            return database!!
        }

        private fun databaseBuilder(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "database-name")
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build()
        }

        private val roomCallback: Callback = object : Callback() {}
    }
}