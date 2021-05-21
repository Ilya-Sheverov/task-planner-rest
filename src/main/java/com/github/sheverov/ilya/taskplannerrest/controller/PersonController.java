package com.github.sheverov.ilya.taskplannerrest.controller;

import com.github.sheverov.ilya.taskplannerrest.PersonDTOService;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDto;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonDTOService personDTOService;

    @GetMapping(path = "/persons")
    public List<PersonDto> getPersons() {
        return personDTOService.getPersonsDTO();
    }

    @GetMapping("/persons/{personId}")
    public PersonDto getPerson(@PathVariable Integer personId) {
        return personDTOService.getPersonDtoById(personId);
    }

    @PostMapping("/persons")
    public void createPerson(@RequestBody @Validated Person person) {
        personDTOService.createPerson(person);
    }
}
