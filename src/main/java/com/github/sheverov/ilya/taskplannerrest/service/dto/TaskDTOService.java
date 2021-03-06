package com.github.sheverov.ilya.taskplannerrest.service.dto;

import com.github.sheverov.ilya.taskplannerrest.converter.dto.TaskToTaskDTOConverter;
import com.github.sheverov.ilya.taskplannerrest.database.PersonRepository;
import com.github.sheverov.ilya.taskplannerrest.database.TaskRepository;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonIdentifyingDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.task.TaskCreatingDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.task.TaskDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import com.github.sheverov.ilya.taskplannerrest.entity.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
public class TaskDTOService {

    final TaskRepository taskRepository;
    final PersonRepository personRepository;
    final TaskToTaskDTOConverter taskToTaskDTOConverter;

    public TaskDTOService(TaskRepository taskRepository,
        PersonRepository personRepository,
        TaskToTaskDTOConverter taskToTaskDTOConverter) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
        this.taskToTaskDTOConverter = taskToTaskDTOConverter;
    }

    public TaskDTO getTaskDTOById(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(taskToTaskDTOConverter::convert).orElse(null);
    }

    public List<TaskDTO> getTaskDTOs() {
        return taskToTaskDTOConverter.convert(taskRepository.findAll());
    }

    public void createTask(TaskCreatingDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setWorkVolume(taskDTO.getWorkVolume());
        task.setStartDate(taskDTO.getStartDate());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(taskDTO.getStatus());
        List<Person> persons = new ArrayList<>(taskDTO.getAssignees().size());
        List<PersonIdentifyingDTO> assignees = taskDTO.getAssignees();
        for (PersonIdentifyingDTO assignee : assignees) {
            Optional<Person> personOptional = personRepository.findById(assignee.getPersonId());
            personOptional.ifPresent(persons::add);
        }
        task.setAssignees(persons);
        taskRepository.save(task);
    }
}
