package uz.abbos.dilmurodjonov.todoapp.di.module

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.di.scope.AppScope

@Module
class RoomModule {

    @Provides
    @AppScope
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(roomCallback)
            .build()
    }

    private val roomCallback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
        // some actions
    }
}

private const val DATABASE_NAME = "database-name"