package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model.TaskApiModel

 data class TaskResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("element") val element: TaskApiModel? = null
)