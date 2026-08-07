package com.iuredev.ToDoList.task.service;

import com.iuredev.ToDoList.task.dto.TaskDTO;
import com.iuredev.ToDoList.task.mapper.TaskMapper;
import com.iuredev.ToDoList.task.model.TaskModel;
import com.iuredev.ToDoList.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskMapper mapper;
    private final TaskRepository repository;

    public TaskService(TaskMapper mapper, TaskRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<TaskDTO> findAllTasks() {
        List<TaskModel> tasks = repository.findAll();
        if (!tasks.isEmpty()) {
            return tasks.stream()
                    .map(mapper::map)
                    .toList();
        }
        return null;
    }

    public TaskDTO findTaskById(UUID id) {
        Optional<TaskModel> taskModel = repository.findById(id);
        return mapper.map(taskModel.orElse(null));
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        if (taskDTO != null) {
            TaskModel taskModel = mapper.map(taskDTO);
            TaskModel savedModel = repository.save(taskModel);
            return mapper.map(savedModel);
        }
        return null;
    }

    public TaskDTO updateTask(UUID id, TaskDTO taskDTO) {
        if (repository.existsById(id)) {
            TaskModel taskModel = mapper.map(taskDTO);
            taskModel.setId(id);
            TaskModel updatedTaskModel = repository.save(taskModel);
            return mapper.map(updatedTaskModel);
        }
        return null;
    }

    public boolean deleteTask(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
