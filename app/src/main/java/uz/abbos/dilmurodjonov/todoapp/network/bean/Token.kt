package uz.abbos.dilmurodjonov.todoapp.network.bean

import com.google.gson.annotations.SerializedName

data class Token(
    val type: String,
    @SerializedName("expires_in") val expiresIn: String,
    @SerializedName("access_token") val accessToken: String
)
