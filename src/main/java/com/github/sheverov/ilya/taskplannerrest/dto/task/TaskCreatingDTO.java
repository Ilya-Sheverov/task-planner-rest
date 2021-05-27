package com.github.sheverov.ilya.taskplannerrest.dto.task;

import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonIdentifyingDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TaskCreatingDTO {

    private String description;
    private Integer workVolume;
    private Timestamp startDate;
    private Timestamp dueDate;
    private String status;
    private List<PersonIdentifyingDTO> assignees = new ArrayList<>();

}
