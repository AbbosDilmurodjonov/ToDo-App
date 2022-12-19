package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.AuthService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.UserService
import uz.abbos.dilmurodjonov.todoapp.di.scope.ServiceScope

@Module(includes = [RetrofitModule::class])
class ServiceModule {

    @ServiceScope
    @Provides
    fun provideTaskService(retrofit: Retrofit): TasksService = retrofit.create(TasksService::class.java)

    @ServiceScope
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)

    @ServiceScope
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)


}