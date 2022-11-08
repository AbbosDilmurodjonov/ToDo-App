package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TokenEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Token

internal data class TokenApiModel(
    @SerializedName("type") val type: String? = null,
    @SerializedName("expires_in") val expiresIn: String? = null,
    @SerializedName("access_token") val accessToken: String? = null
)

internal fun TokenApiModel.toEntityModel() =
    TokenEntityModel(
        type = this.type ?: "",
        expiresIn = this.expiresIn ?: "",
        accessToken = this.accessToken ?: ""
    )

internal fun TokenApiModel.toDomainModel() =
    Token(
        type = this.type ?: "",
        expiresIn = this.expiresIn ?: "",
        accessToken = this.accessToken ?: ""
    )
