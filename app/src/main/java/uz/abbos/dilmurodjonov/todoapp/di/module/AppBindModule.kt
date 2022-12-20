package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Binds
import dagger.Module
import uz.abbos.dilmurodjonov.todoapp.data.repository.TaskRepositoryImpl
import uz.abbos.dilmurodjonov.todoapp.domain.repository.TaskRepository

@Module
interface AppBindModule {

    @Suppress("FunctionName")
    @Binds
    fun bindTaskRepositoryImpl_to_TaskRepository(
        taskRepositoryImpl: TaskRepositoryImpl
    ): TaskRepository
}