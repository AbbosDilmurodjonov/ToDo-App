package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TaskPriorityEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority

 enum class TaskImportanceApiModel {

    @SerializedName("low")
    LOW,

    @SerializedName("basic")
    BASIC,

    @SerializedName("importance")
    IMPORTANCE,

    @SerializedName("")
    UNKNOWN
}

 fun TaskImportanceApiModel.toDomainModel() = TaskPriority.valueOf(this.name)

 fun TaskImportanceApiModel.toEntityModel() =
    TaskPriorityEntityModel.values().firstOrNull { it.ordinal == this.ordinal }