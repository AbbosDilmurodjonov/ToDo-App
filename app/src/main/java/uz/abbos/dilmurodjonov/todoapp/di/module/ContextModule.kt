package uz.abbos.dilmurodjonov.todoapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.AppContext

@Module
class ContextModule(val context: Context) {

    @AppContext
    @Provides
    fun provideContext(): Context = context.applicationContext
}