package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.service

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import uz.abbos.dilmurodjonov.todoapp.common.data.retrofit.ApiResult
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model.UserApiModel
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response.GetUserResponse
import uz.abbos.dilmurodjonov.todoapp.domain.entities.User

 interface UserService {

    @GET("user")
    fun getUser(): ApiResult<GetUserResponse>

    @PUT("user")
    fun update(@Body user: UserApiModel): ApiResult<GetUserResponse>
}