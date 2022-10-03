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
                    database = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "database-name"
                    ).fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }

            return database!!
        }

        private val roomCallback: Callback = object : Callback() {}
    }
}