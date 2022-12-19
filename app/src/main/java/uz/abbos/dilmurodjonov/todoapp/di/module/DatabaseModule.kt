package uz.abbos.dilmurodjonov.todoapp.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.AppContext
import uz.abbos.dilmurodjonov.todoapp.di.scope.DatabaseScope


@Module
class DatabaseModule {

    @DatabaseScope
    @Provides
    fun provideDatabase(@AppContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database-name")
            .fallbackToDestructiveMigration()
            .addCallback(roomCallback)
            .build()
    }

    private val roomCallback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
        // some actions
    }
}