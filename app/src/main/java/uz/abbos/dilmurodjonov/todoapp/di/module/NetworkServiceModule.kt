package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService

@Module(includes = [OkHttpModule::class, RetrofitModule::class])
class NetworkServiceModule {

    @Provides
    fun provideTaskService(retrofit: Retrofit): TasksService {
        return retrofit.create(TasksService::class.java)
    }

}