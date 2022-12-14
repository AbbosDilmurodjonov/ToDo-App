package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model.TokenApiModel

 data class AuthResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("token") val token: TokenApiModel? = null
)
