package uz.abbos.dilmurodjonov.todoapp.network.bean

import com.google.gson.annotations.SerializedName
import java.util.*

data class ToDo(
    val id: Int,
    val text: String,
    val importance: String,
    val deadline: Date,
    val done: Boolean,
    val color: String? = null,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("last_updated_by") val lastUpdatedBy: String
)
