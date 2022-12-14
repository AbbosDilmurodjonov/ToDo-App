package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model.UserApiModel

 data class GetUserResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("user") val user: UserApiModel? = null,
)
