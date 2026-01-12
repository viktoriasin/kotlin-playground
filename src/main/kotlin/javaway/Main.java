package javaway;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Task 1", false, TaskType.PERSONAL, Instant.now(), Instant.now());
        Task task2 = new Task(2, "Task 2", true, TaskType.STUDY, Instant.now(), Instant.now());

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        System.out.println(taskManager.getAllTasks());
        System.out.println(taskManager.filterByType(TaskType.PERSONAL));
        taskManager.completeTask(1);
        System.out.println(taskManager.getAllTasks());

        taskManager.removeTask(2);
        System.out.println(taskManager.getAllTasks());
    }
}
