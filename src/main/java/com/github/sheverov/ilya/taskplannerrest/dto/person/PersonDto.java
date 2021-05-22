package com.github.sheverov.ilya.taskplannerrest.dto.person;

import java.sql.Timestamp;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonDto {

    private Integer personId;
    private String lastName;
    private String firstName;
    private String middleName;
    private Timestamp version;
}
