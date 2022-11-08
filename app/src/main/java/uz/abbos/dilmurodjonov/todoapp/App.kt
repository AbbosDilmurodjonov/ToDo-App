package uz.abbos.dilmurodjonov.todoapp

import android.app.Application
import android.content.Context

/**
 * Custom Application class allows to hold reference to [applicationComponent]
 * as long as application lives.
 */
class App : Application() {

    companion object {
        /**
         * Shortcut to get [App] instance from any context, e.g. from Activity.
         */
        fun get(context: Context) = context.applicationContext as App
    }
}