package ru.sinvic.kotlinway

class TaskManager {
    private val taskStorage = HashMap<Int, Task>();

    operator fun plusAssign(task: Task) {
        taskStorage[task.id] = task
    }

    operator fun minusAssign(id: Int) {
        taskStorage.remove(id)
    }

    fun completeTask(id: Int) {
        findTaskById(id)?.let { task ->
            require(!task.isCompleted) { "Task with ID=$id is already completed" }
            taskStorage[id] = task.copy(isCompleted = true)
        } ?: throw NoSuchElementException("Task with ID=$id is not found")
    }

    fun findTaskById(id: Int): Task? = taskStorage[id]

    fun getAllTasks(): List<Task> = taskStorage.values.toList()

    fun getTaskByType(taskType: TaskType): List<Task> = taskStorage.values.byType(taskType)

    private fun Collection<Task>.byType(type: TaskType): List<Task> =
        filter { it.type == type }
}
