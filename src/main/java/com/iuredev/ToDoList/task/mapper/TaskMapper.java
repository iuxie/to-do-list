package com.iuredev.ToDoList.task.mapper;

import com.iuredev.ToDoList.task.dto.TaskDTO;
import com.iuredev.ToDoList.task.model.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "createdAt", ignore = true)
    TaskModel map(TaskDTO taskDTO);

    TaskDTO map(TaskModel taskModel);

}
