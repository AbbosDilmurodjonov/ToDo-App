package uz.abbos.dilmurodjonov.todoapp.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import uz.abbos.dilmurodjonov.todoapp.network.bean.User

interface UserService {

    @GET("user")
    fun getUser(): Response<User>

    @PUT("user")
    fun update(@Body user: User): Response<User>
}