package uz.abbos.dilmurodjonov.todoapp.data.datasource.api.model

import com.google.gson.annotations.SerializedName
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TaskPriorityEntityModel
import uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model.TasksEntityModel
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority
import java.util.*

 data class TaskApiModel(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("text") val text: String? = null,
    @SerializedName("importance") val importance: TaskImportanceApiModel? = null,
    @SerializedName("deadline") val deadline: Long? = null,
    @SerializedName("done") val done: Boolean? = null,
    @SerializedName("color") val color: String? = null,
    @SerializedName("created_at") val createdAt: Long? = null,
    @SerializedName("updated_at") val updatedAt: Long? = null,
    @SerializedName("last_updated_by") val lastUpdatedBy: String? = null
)

 fun TaskApiModel.toEntityModel() =
    TasksEntityModel(
        id = this.id ?: 0,
        text = this.text ?: "",
        priority = this.importance?.toEntityModel() ?: TaskPriorityEntityModel.BASIC,
        deadline = if (this.deadline == null) Date() else Date(this.deadline),
        isDone = this.done ?: false,
        createdDate = if (this.createdAt == null) Date() else Date(this.createdAt),
        updatedDate = this.updatedAt?.let { Date(updatedAt) }
    )


 fun TaskApiModel.toDomainModel() =
    Task(
        id = this.id ?: 0,
        text = this.text ?: "",
        priority = this.importance?.toDomainModel() ?: TaskPriority.BASIC,
        deadline = if (this.deadline == null) Date() else Date(this.deadline),
        isDone = this.done ?: false,
        createdDate = if (this.createdAt == null) Date() else Date(this.createdAt),
        updatedDate = this.updatedAt?.let { Date(updatedAt) }
    )

