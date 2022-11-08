package uz.abbos.dilmurodjonov.todoapp.domain.entities

internal data class Token(
    val type: String,
    val expiresIn: String,
    val accessToken: String
)
