package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Module
import dagger.Provides
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.AppDatabase
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao

@Module(includes = [RoomModule::class])
class DaoModule {

    @Provides
    fun provideTaskDao(appDatabase: AppDatabase): TasksDao {
        return appDatabase.taskDao()
    }

}