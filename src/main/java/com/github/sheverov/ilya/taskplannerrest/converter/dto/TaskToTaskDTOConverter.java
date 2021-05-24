package com.github.sheverov.ilya.taskplannerrest.converter.dto;

import com.github.sheverov.ilya.taskplannerrest.dto.task.TaskDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Task;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TaskToTaskDTOConverter {

    public TaskDTO convert(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO
            .setId(task.getId())
            .setDescription(task.getDescription())
            .setWorkVolume(task.getWorkVolume())
            .setStartDate(task.getStartDate())
            .setDueDate(task.getDueDate())
            .setStatus(task.getStatus())
            .setAssignees(task.getAssignees())
            .setVersion(task.getVersion());
        return taskDTO;
    }

    public List<TaskDTO> convert(List<Task> tasks) {
        return tasks.stream().map(this::convert).collect(Collectors.toList());
    }
}
