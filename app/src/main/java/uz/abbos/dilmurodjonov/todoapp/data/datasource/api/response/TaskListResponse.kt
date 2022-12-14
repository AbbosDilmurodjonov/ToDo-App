package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model.TaskApiModel

 data class TaskListResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("list") val list: List<TaskApiModel>? = null
)