package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model

internal data class TokenEntityModel(
    val type: String,
    val expiresIn: String,
    val accessToken: String
)
