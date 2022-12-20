package uz.abbos.dilmurodjonov.todoapp.di.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.ApiKeyQualifier
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.AuthInterceptorQualifier
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.ChuckerInterceptorQualifier
import uz.abbos.dilmurodjonov.todoapp.di.qualifier.LoggingInterceptorQualifier
import uz.abbos.dilmurodjonov.todoapp.di.scope.AppScope
import java.util.concurrent.TimeUnit

@Module
class OkHttpModule {

    @Provides
    @AppScope
    fun provideOkHttpClient(
        @LoggingInterceptorQualifier loggingInterceptor: Interceptor,
        @ChuckerInterceptorQualifier chuckerInterceptor: Interceptor,
        @AuthInterceptorQualifier authInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @LoggingInterceptorQualifier
    fun provideHttpLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @ChuckerInterceptorQualifier
    fun provideChuckerInterceptor(context: Context): Interceptor {
        val collector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        return ChuckerInterceptor.Builder(context)
            // The previously created Collector
            .collector(collector)
            // The max body content length in bytes, after this responses will be truncated.
            .maxContentLength(250_000L)
            // List of headers to replace with ** in the Chucker UI
            .redactHeaders("Auth-Token", "Bearer")
            // Read the whole response body even when the client does not consume the response completely.
            // This is useful in case of parsing errors or when the response body
            // is closed before being read like in Retrofit with Void and Unit types.
            .alwaysReadResponseBody(true)
            .build()
    }

    @Provides
    @AuthInterceptorQualifier
    fun provideAuthInterceptor(@ApiKeyQualifier apiKey: String): Interceptor {
        val interceptor = Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build()

            it.proceed(request)
        }

        return interceptor
    }
}