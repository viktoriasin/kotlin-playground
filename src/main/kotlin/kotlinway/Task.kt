package ru.sinvic.kotlinway

import java.time.Instant

data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false,
    val type: TaskType = TaskType.PERSONAL,
    val createdAt: Instant = Instant.now(),
    val modifiedAt: Instant = Instant.now()
) {
    init {
        require(title.isNotBlank()) { "Title of task can not be empty." }
    }
}