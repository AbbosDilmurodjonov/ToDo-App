package uz.abbos.dilmurodjonov.todoapp.di.component

import dagger.Component
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.dao.TasksDao
import uz.abbos.dilmurodjonov.todoapp.di.module.DaoModule
import uz.abbos.dilmurodjonov.todoapp.di.scope.DatabaseScope

@DatabaseScope
@Component(modules = [DaoModule::class])
interface DaoComponent {

    fun taskDao(): TasksDao
}