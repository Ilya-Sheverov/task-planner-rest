package com.github.sheverov.ilya.taskplannerrest.controller;

import com.github.sheverov.ilya.taskplannerrest.service.dto.PersonDTOService;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonWithTasksDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonDTOService personDTOService;

    @GetMapping(path = "/persons")
    public Map<String, Object> getPersons(
        @RequestParam(defaultValue = "false") boolean includingTasks) {
        if (includingTasks) {
            List<PersonWithTasksDTO> personWithTasksDTOS = personDTOService
                .getPersonWithTasksDTOs();
            return Map.of("persons", personWithTasksDTOS);
        } else {
            List<PersonDTO> personDTOS = personDTOService.getPersonDTOs();
            return Map.of("persons", personDTOS);
        }
    }

    @GetMapping("/persons/{personId}")
    public Map<String, Object> getPerson(@PathVariable Integer personId,
        @RequestParam(defaultValue = "false") boolean includingTasks) {
        if (includingTasks) {
            PersonWithTasksDTO personWithTasksDto = personDTOService
                .getPersonWithTasksDtoById(personId);
            return Map.of("person", personWithTasksDto);
        } else {
            PersonDTO personDto = personDTOService.getPersonDtoById(personId);
            return Map.of("person", personDto);
        }
    }

    @PostMapping("/persons")
    public void createPerson(@RequestBody @Validated Person person) {
        personDTOService.createPerson(person);
    }

    @DeleteMapping("/persons")
    public void deletePerson(@RequestBody Person person) {
        personDTOService.deletePerson(person);
    }
}
