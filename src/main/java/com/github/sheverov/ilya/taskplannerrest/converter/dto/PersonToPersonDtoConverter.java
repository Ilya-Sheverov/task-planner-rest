package com.github.sheverov.ilya.taskplannerrest.converter.dto;

import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDto;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PersonToPersonDtoConverter {

    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();
        personDto
            .setPersonId(person.getPersonId())
            .setLastName(person.getLastName())
            .setFirstName(person.getFirstName())
            .setMiddleName(person.getMiddleName())
            .setVersion(person.getVersion());
        return personDto;
    }

    public List<PersonDto> convert(List<Person> persons) {
        return persons.stream().map(this::convert)
            .collect(Collectors.toList());
    }
}
