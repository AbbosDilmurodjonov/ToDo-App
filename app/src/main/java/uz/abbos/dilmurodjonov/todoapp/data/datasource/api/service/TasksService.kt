package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service

import retrofit2.http.*
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response.TaskListResponse
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response.TaskResponse
import uz.abbos.dilmurodjonov.todoapp.common.data.retrofit.ApiResult

internal interface TasksService {

    @GET("list")
    suspend fun getAll(
        @Query("page") page: Int,
        @Query("perPage") count: Int = 100
    ): ApiResult<TaskListResponse>

    @PATCH("list")
    suspend fun updateList(
        @Body list: TaskListResponse
    ): ApiResult<TaskListResponse>

    @POST("list")
    suspend fun add(
        @Body bean: TaskResponse
    ): ApiResult<TaskResponse>

    @GET("list/{id}")
    suspend fun getById(
        @Path("id") id: Int
    ): ApiResult<TaskResponse>

    @PUT("list/{id}")
    suspend fun updateById(
        @Path("id") id: Int,
        @Body bean: TaskResponse
    ): ApiResult<TaskResponse>

    @DELETE("list/{id}")
    suspend fun deleteById(
        @Path("id") id: Int
    ): ApiResult<TaskResponse>

}