package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TaskPriorityEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority

internal enum class TaskImportanceApiModel {

    @SerializedName("LOW")
    LOW,

    @SerializedName("BASIC")
    BASIC,

    @SerializedName("IMPORTANCE")
    IMPORTANCE,

    @SerializedName("")
    UNKNOWN
}

internal fun TaskImportanceApiModel.toDomainModel() = TaskPriority.valueOf(this.name)

internal fun TaskImportanceApiModel.toEntityModel() =
    TaskPriorityEntityModel.values().firstOrNull { it.ordinal == this.ordinal }