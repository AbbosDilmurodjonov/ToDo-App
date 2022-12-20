package uz.abbos.dilmurodjonov.todoapp.di.module

import dagger.Module
import uz.abbos.dilmurodjonov.todoapp.di.component.FeatureTaskDetailsComponent
import uz.abbos.dilmurodjonov.todoapp.di.component.FeatureTaskListComponent

@Module(
    includes = [
        NetworkServiceModule::class,
        DaoModule::class,
        AppBindModule::class
    ],
    subcomponents = [
        FeatureTaskListComponent::class,
        FeatureTaskDetailsComponent::class
    ],
)
class AppModule