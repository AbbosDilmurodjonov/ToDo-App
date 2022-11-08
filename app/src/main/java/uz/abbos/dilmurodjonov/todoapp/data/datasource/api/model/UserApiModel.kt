package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.UserEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.entities.User

internal data class UserApiModel(
    @SerializedName("name") val name: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("email") val email: String? = null
)

internal fun UserApiModel.toEntityModel() =
    UserEntityModel(
        name = this.name ?: "",
        phone = this.phone ?: "",
        email = this.email ?: ""
    )

internal fun UserApiModel.toDomainModel() =
    User(
        name = this.name ?: "",
        phone = this.phone ?: "",
        email = this.email ?: ""
    )
