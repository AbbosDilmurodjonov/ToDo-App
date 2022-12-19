package uz.abbos.dilmurodjonov.todoapp.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service.TasksService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//@Module
class NetworkModule {
//    @Singleton
//    @Provides
//    fun provideTaskService(retrofit: Retrofit): TasksService {
//        return retrofit.create(TasksService::class.java)
//    }
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(client: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("http://localhost:8080")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(context: Context): OkHttpClient {
//        return OkHttpClient.Builder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .addInterceptor(provideHttpLoggingInterceptor())
//            .addInterceptor(provideChuckerInterceptor(context))
//            .addInterceptor(provideAuthInterceptor("SOME_TOKEN"))
//            .build()
//    }
//
//    private fun provideHttpLoggingInterceptor(): Interceptor {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        return interceptor
//    }
//
//    private fun provideChuckerInterceptor(context: Context): Interceptor {
//        val collector = ChuckerCollector(
//            context = context,
//            showNotification = true,
//            retentionPeriod = RetentionManager.Period.ONE_HOUR
//        )
//
//        return ChuckerInterceptor.Builder(context)
//            // The previously created Collector
//            .collector(collector)
//            // The max body content length in bytes, after this responses will be truncated.
//            .maxContentLength(250_000L)
//            // List of headers to replace with ** in the Chucker UI
//            .redactHeaders("Auth-Token", "Bearer")
//            // Read the whole response body even when the client does not consume the response completely.
//            // This is useful in case of parsing errors or when the response body
//            // is closed before being read like in Retrofit with Void and Unit types.
//            .alwaysReadResponseBody(true)
//            .build()
//    }
//
//    private fun provideAuthInterceptor(apiKey: String): Interceptor {
//        val interceptor = Interceptor {
//            val request = it.request().newBuilder()
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", apiKey)
//                .build()
//
//            it.proceed(request)
//        }
//
//        return interceptor
//    }


}