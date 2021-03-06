package com.github.sheverov.ilya.taskplannerrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonIdentifyingDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.task.TaskCreatingDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.task.TaskDTO;
import com.github.sheverov.ilya.taskplannerrest.service.dto.TaskDTOService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    final TaskDTOService taskDTOService;

    public TaskController(TaskDTOService taskDTOService) {
        this.taskDTOService = taskDTOService;
    }

    @GetMapping("/tasks")
    public Map<String, Object> getTaskDTOs() {
        return Map.of("tasks", taskDTOService.getTaskDTOs());
    }

    @GetMapping("/tasks/{taskId}")
    public Map<String,Object> getTaskDTOById(@PathVariable Integer taskId) {
        return  Map.of("task", taskDTOService.getTaskDTOById(taskId));
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody TaskCreatingDTO taskDTO){
        taskDTOService.createTask(taskDTO);
    }
}
