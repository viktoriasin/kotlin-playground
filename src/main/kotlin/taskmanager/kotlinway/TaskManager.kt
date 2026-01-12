package ru.sinvic.taskmanager.kotlinway

class TaskManager {
    private val taskStorage: MutableMap<Int, Task> = HashMap()

    operator fun plusAssign(task: Task) {
        taskStorage[task.id] = task
    }

    operator fun minusAssign(id: Int) {
        taskStorage.remove(id)
    }

    fun completeTask(id: Int) {
        val task = findTaskById(id) ?: return
        if (task.isCompleted) return
        taskStorage[id] = task.copy(isCompleted = true)
    }

    fun findTaskById(id: Int): Task? = taskStorage[id]

    fun getAllTasks(): List<Task> = taskStorage.values.toList()

    fun getTaskByType(taskType: TaskType): List<Task> = taskStorage.values.byType(taskType)

    private fun Collection<Task>.byType(type: TaskType): List<Task> =
        filter { it.type == type }
}
