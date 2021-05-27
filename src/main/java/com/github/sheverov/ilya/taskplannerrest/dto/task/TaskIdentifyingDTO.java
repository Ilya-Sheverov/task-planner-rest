package com.github.sheverov.ilya.taskplannerrest.dto.task;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskIdentifyingDTO {

    private Integer id;
    private Timestamp version;
}
