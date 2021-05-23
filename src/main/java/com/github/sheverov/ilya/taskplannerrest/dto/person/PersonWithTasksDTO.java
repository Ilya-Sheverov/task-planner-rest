package com.github.sheverov.ilya.taskplannerrest.dto.person;

import com.github.sheverov.ilya.taskplannerrest.entity.Task;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonWithTasksDTO {

    private Integer personId;
    private String lastName;
    private String firstName;
    private String middleName;
    private Timestamp version;
    private List<Task> tasks = new ArrayList<>();

}
