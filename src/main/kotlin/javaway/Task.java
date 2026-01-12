package javaway;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public record Task(
    int taskId,
    @NotNull String title,
    boolean isCompleted,
    @NotNull TaskType taskType,
    @NotNull Instant createdAt,
    @NotNull Instant modifiedAt
) {
    public Task {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title of task can not be empty.");
        }
    }
};
