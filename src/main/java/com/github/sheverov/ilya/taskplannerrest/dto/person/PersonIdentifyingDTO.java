package com.github.sheverov.ilya.taskplannerrest.dto.person;


import java.sql.Timestamp;
import lombok.Data;

@Data
public class PersonIdentifyingDTO {

    private Integer personId;
    private Timestamp version;
}
