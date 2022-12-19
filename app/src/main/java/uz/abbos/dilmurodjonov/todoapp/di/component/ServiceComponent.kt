package uz.abbos.dilmurodjonov.todoapp.di.component

import dagger.Component
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.AuthService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.UserService
import uz.abbos.dilmurodjonov.todoapp.di.module.ServiceModule
import uz.abbos.dilmurodjonov.todoapp.di.scope.ServiceScope

@ServiceScope
@Component(modules = [ServiceModule::class])
interface ServiceComponent {
    fun taskService(): TasksService
    fun userService(): UserService
    fun authService(): AuthService
}