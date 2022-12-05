package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model

import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority

internal enum class TaskPriorityEntityModel {
    LOW, BASIC, IMPORTANT;

    companion object {
        internal fun fromDomainModel(priority: TaskPriority) =
            values().firstOrNull { it.ordinal == priority.ordinal }
                ?: BASIC
    }
}

internal fun TaskPriorityEntityModel.toDomainModel() =
    TaskPriority.values().firstOrNull { it.ordinal == this.ordinal }
        ?: TaskPriority.BASIC

