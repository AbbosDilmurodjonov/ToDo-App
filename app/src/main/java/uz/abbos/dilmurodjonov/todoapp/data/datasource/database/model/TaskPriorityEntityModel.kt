package uz.abbos.dilmurodjonov.todoapp.data.datasource.database.model

import uz.abbos.dilmurodjonov.todoapp.domain.enums.TaskPriority

 enum class TaskPriorityEntityModel {
    LOW, BASIC, IMPORTANT;

    companion object {
         fun fromDomainModel(priority: TaskPriority) =
            values().firstOrNull { it.ordinal == priority.ordinal }
                ?: BASIC
    }
}

 fun TaskPriorityEntityModel.toDomainModel() =
    TaskPriority.values().firstOrNull { it.ordinal == this.ordinal }
        ?: TaskPriority.BASIC

