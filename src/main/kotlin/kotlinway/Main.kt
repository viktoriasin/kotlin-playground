package ru.sinvic.kotlinway

fun main() {
    val manager = TaskManager();

    manager += Task(1, "Task 1", false, TaskType.STUDY)
    manager += Task(2, "Task 2", false)

    manager.getAllTasks().forEach { task ->
        println(task)
    }

    manager.completeTask(1)

    manager.getAllTasks().forEach { task ->
        println(task)
    }

    manager.getTaskByType(TaskType.PERSONAL).forEach { task ->
        println(task)
    }

}