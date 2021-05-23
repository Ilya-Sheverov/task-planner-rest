package com.github.sheverov.ilya.taskplannerrest.converter.dto;

import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PersonToPersonDtoConverter {

    public PersonDTO convert(Person person) {
        PersonDTO personDto = new PersonDTO();
        personDto
            .setPersonId(person.getPersonId())
            .setLastName(person.getLastName())
            .setFirstName(person.getFirstName())
            .setMiddleName(person.getMiddleName())
            .setVersion(person.getVersion());
        return personDto;
    }

    public List<PersonDTO> convert(List<Person> persons) {
        return persons.stream().map(this::convert)
            .collect(Collectors.toList());
    }
}
