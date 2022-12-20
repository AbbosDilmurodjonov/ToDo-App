package uz.abbos.dilmurodjonov.todoapp

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.abbos.dilmurodjonov.todoapp.di.component.FeatureTaskDetailsComponent
import uz.abbos.dilmurodjonov.todoapp.di.component.FeatureTaskListComponent
import uz.abbos.dilmurodjonov.todoapp.di.module.AppModule
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.ApiKeyQualifier
import uz.abbos.dilmurodjonov.todoapp.di.scope.AppScope

@[AppScope Component(modules = [AppModule::class])]
interface AppComponent {

    fun featureTaskListComponent(): FeatureTaskListComponent.Builder
    fun featureTaskDetailsComponent(): FeatureTaskDetailsComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun apiKey(@ApiKeyQualifier apiKey: String): Builder

        fun build(): AppComponent
    }
}




