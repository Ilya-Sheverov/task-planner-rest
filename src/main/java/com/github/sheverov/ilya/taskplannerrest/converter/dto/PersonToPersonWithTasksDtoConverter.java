package com.github.sheverov.ilya.taskplannerrest.converter.dto;

import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonWithTasksDto;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PersonToPersonWithTasksDtoConverter {

    public PersonWithTasksDto convert(Person person) {
        PersonWithTasksDto personWithTasksDto = new PersonWithTasksDto();
        personWithTasksDto
            .setPersonId(person.getPersonId())
            .setLastName(person.getLastName())
            .setFirstName(person.getFirstName())
            .setMiddleName(person.getMiddleName())
            .setVersion(person.getVersion())
            .setTasks(person.getTasks());
        return personWithTasksDto;
    }

    public List<PersonWithTasksDto> convert(List<Person> persons) {
        return persons.stream().map(this::convert).collect(Collectors.toList());
    }

}
