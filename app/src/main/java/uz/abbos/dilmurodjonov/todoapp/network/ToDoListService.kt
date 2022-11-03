package uz.abbos.dilmurodjonov.todoapp.network

import retrofit2.Response
import retrofit2.http.*
import uz.abbos.dilmurodjonov.todoapp.network.bean.ToDoListResponse
import uz.abbos.dilmurodjonov.todoapp.network.bean.ToDoResponse

interface ToDoListService {

    @GET("list")
    suspend fun getAll(): Response<ToDoListResponse>

    @PATCH("list")
    fun updateList(@Body list: ToDoListResponse): Response<ToDoListResponse>

    @POST("list")
    fun add(@Body bean: ToDoResponse): Response<ToDoResponse>

    @GET("list/{id}")
    fun getById(@Path("id") id: Int): Response<ToDoResponse>

    @PUT("list/{id}")
    fun updateById(@Path("id") id: Int, @Body bean: ToDoResponse): Response<ToDoResponse>

    @DELETE("list/{id}")
    fun deleteById(@Path("id") id: Int): Response<ToDoResponse>

}