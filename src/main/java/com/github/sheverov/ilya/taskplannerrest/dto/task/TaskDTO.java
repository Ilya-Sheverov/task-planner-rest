package com.github.sheverov.ilya.taskplannerrest.dto.task;

import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskDTO {

    private Integer id;
    private String description;
    private Integer workVolume;
    private Timestamp startDate;
    private Timestamp dueDate;
    private String status;
    private List<PersonDTO> assignees = new ArrayList<>();
    private Timestamp version;

}
