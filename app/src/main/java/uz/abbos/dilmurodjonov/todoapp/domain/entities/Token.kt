package uz.abbos.dilmurodjonov.todoapp.domain.entities

 data class Token(
    val type: String,
    val expiresIn: String,
    val accessToken: String
)
