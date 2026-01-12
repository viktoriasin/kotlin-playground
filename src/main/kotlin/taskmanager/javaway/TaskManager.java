package taskmanager.javaway;

import java.time.Instant;
import java.util.*;

public class TaskManager {
    private final Map<Integer, Task> taskStorage = new HashMap<>();

    public void addTask(Task task) {
        taskStorage.put(task.taskId(), task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskStorage.values());
    }

    public void completeTask(int taskId) {
        Task taskToComplete = findTaskById(taskId).orElseThrow();

        if (taskToComplete.isCompleted()) {
            throw new IllegalArgumentException(String.format("Task with id %d already completed!", taskId));
        }

        Task completedTask = new Task(taskToComplete.taskId(),
            taskToComplete.title(),
            true,
            taskToComplete.taskType(),
            taskToComplete.createdAt(),
            Instant.now());
        taskStorage.put(taskId, completedTask);
    }

    public void removeTask(int taskId) {
        taskStorage.remove(taskId);
    }

    public Optional<Task> findTaskById(int taskId) {
        return Optional.of(taskStorage.get(taskId));
    }

    public List<Task> filterByType(TaskType taskType) {
        return taskStorage.values().stream()
            .filter(task -> task.taskType() == taskType)
            .toList();
    }
}
