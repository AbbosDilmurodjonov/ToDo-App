package uz.abbos.dilmurodjonov.todoapp

import android.app.Application
import android.content.Context
import uz.abbos.dilmurodjonov.todoapp.domain.usecases.*

/**
 * Custom Application class allows to hold reference to [appComponent]
 * as long as application lives.
 */
class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .apiKey("Suy!c1X2yf%EQyn46I%xbs0R4I%6^D@DQ*!xNEWC1WGo22306o")
            .context(this)
            .build()
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }