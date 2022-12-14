package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TokenEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Token

 data class TokenApiModel(
    @SerializedName("type") val type: String? = null,
    @SerializedName("expires_in") val expiresIn: String? = null,
    @SerializedName("access_token") val accessToken: String? = null
)

 fun TokenApiModel.toEntityModel() =
    TokenEntityModel(
        type = this.type ?: "",
        expiresIn = this.expiresIn ?: "",
        accessToken = this.accessToken ?: ""
    )

 fun TokenApiModel.toDomainModel() =
    Token(
        type = this.type ?: "",
        expiresIn = this.expiresIn ?: "",
        accessToken = this.accessToken ?: ""
    )
