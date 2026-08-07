package com.iuredev.ToDoList.task.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(UUID id, String title, String description, boolean completed, LocalDateTime createdAt) {
}
