package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model

import androidx.room.*
import uz.abbos.dilmurodjonov.todoapp.domain.entities.Task
import java.util.*

@Entity(tableName = "tasks")
@TypeConverters(
    TaskPriorityEntityTypeConverter::class,
    TaskDateEntityTypeConverter::class,
    TaskBooleanEntityTypeConverter::class
)
 data class TasksEntityModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "priority") val priority: TaskPriorityEntityModel,
    @ColumnInfo(name = "deadline") val deadline: Date?,
    @ColumnInfo(name = "is_done") val isDone: Boolean = false,
    @ColumnInfo(name = "created_date") val createdDate: Date,
    @ColumnInfo(name = "updated_date") val updatedDate: Date?
) {
    companion object {
        fun fromDomainModel(task: Task): TasksEntityModel =
            TasksEntityModel(
                id = task.id,
                text = task.text,
                priority = TaskPriorityEntityModel.fromDomainModel(task.priority),
                deadline = task.deadline,
                isDone = task.isDone,
                createdDate = task.createdDate,
                updatedDate = task.updatedDate
            )
    }
}

 fun TasksEntityModel.toDomainModel() =
    Task(
        id = this.id,
        text = this.text,
        priority = this.priority.toDomainModel(),
        deadline = this.deadline,
        isDone = this.isDone,
        createdDate = this.createdDate,
        updatedDate = this.updatedDate
    )

 class TaskPriorityEntityTypeConverter {
    @TypeConverter
    fun enumToString(priority: TaskPriorityEntityModel) = priority.name

    @TypeConverter
    fun stringToEnum(value: String) = TaskPriorityEntityModel.valueOf(value)
}

 class TaskDateEntityTypeConverter {
    @TypeConverter
    fun dateToLong(date: Date?) = date?.time

    @TypeConverter
    fun longToDate(value: Long?) = value?.let { Date(it) }
}

 class TaskBooleanEntityTypeConverter {
    @TypeConverter
    fun boolToInt(isDone: Boolean) = if (isDone) 1 else 0

    @TypeConverter
    fun intToBool(value: Int) = value == 1
}