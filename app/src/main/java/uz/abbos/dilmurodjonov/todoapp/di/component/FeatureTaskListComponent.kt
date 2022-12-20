package uz.abbos.dilmurodjonov.todoapp.di.component

import dagger.Subcomponent
import uz.abbos.dilmurodjonov.todoapp.di.module.FeatureTaskListModule
import uz.abbos.dilmurodjonov.todoapp.di.scope.FeatureTaskListScope
import uz.abbos.dilmurodjonov.todoapp.ui.tasklist.TaskListFragment

@[FeatureTaskListScope Subcomponent(modules = [FeatureTaskListModule::class])]
interface FeatureTaskListComponent {

    fun inject(fragment: TaskListFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FeatureTaskListComponent
    }
}