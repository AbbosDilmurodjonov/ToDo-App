package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Module
import dagger.Provides
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.ActivityContext
import uz.abbos.dilmurodjonov.todoapp.ui.activity.MainActivity
import uz.abbos.dilmurodjonov.todoapp.ui.adapter.TaskListAdapter

@Module
class ActivityModule(val activity: MainActivity) {

//    @ActivityContext
//    @Provides
//    fun provideTaskAdapter(): TaskListAdapter {
//        return TaskListAdapter()
//    }
}