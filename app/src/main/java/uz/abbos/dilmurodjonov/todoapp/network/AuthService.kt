package uz.abbos.dilmurodjonov.todoapp.network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import uz.abbos.dilmurodjonov.todoapp.network.bean.Auth

interface AuthService {

    @POST("sign-up")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun signUp(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("device_id") deviceId: String,
        @Field("device_name") deviceName: String,
        @Field("device_os") deviceOs: String,
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
    ): Response<Auth>

    @POST("auth")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun getToken(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("device_id") deviceId: String,
        @Field("device_name") deviceName: String,
        @Field("device_os") deviceOs: String
    ): Response<Auth>
}