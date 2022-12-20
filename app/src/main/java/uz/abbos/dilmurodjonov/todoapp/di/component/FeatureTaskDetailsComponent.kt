package uz.abbos.dilmurodjonov.todoapp.di.component

import dagger.Subcomponent
import uz.abbos.dilmurodjonov.todoapp.di.module.FeatureTaskDetailsModule
import uz.abbos.dilmurodjonov.todoapp.di.scope.FeatureTaskDetailsScope
import uz.abbos.dilmurodjonov.todoapp.ui.taskdetail.TaskDetailFragment

@[FeatureTaskDetailsScope Subcomponent(modules = [FeatureTaskDetailsModule::class])]
interface FeatureTaskDetailsComponent {

    fun inject(fragment: TaskDetailFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FeatureTaskDetailsComponent
    }
}