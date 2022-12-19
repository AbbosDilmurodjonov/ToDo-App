package uz.abbos.dilmurodjonov.todoapp.di.component

import dagger.Component
import uz.abbos.dilmurodjonov.todoapp.di.module.ActivityModule
import uz.abbos.dilmurodjonov.todoapp.di.scope.ActivityScope
import uz.abbos.dilmurodjonov.todoapp.ui.activity.MainActivity

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ServiceComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}