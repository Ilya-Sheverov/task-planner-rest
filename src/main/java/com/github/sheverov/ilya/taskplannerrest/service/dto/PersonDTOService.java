package com.github.sheverov.ilya.taskplannerrest.service.dto;

import com.github.sheverov.ilya.taskplannerrest.converter.dto.PersonToPersonDtoConverter;
import com.github.sheverov.ilya.taskplannerrest.converter.dto.PersonToPersonWithTasksDtoConverter;
import com.github.sheverov.ilya.taskplannerrest.database.PersonRepository;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonDTO;
import com.github.sheverov.ilya.taskplannerrest.dto.person.PersonWithTasksDTO;
import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
public class PersonDTOService {

    private final PersonRepository personRepository;

    private final PersonToPersonDtoConverter personToPersonDtoConverter;

    private final PersonToPersonWithTasksDtoConverter personWithTasksDtoConverter;


    public PersonDTOService(PersonRepository personRepository,
        PersonToPersonDtoConverter personToPersonDtoConverter,
        PersonToPersonWithTasksDtoConverter personWithTasksDtoConverter) {
        this.personRepository = personRepository;
        this.personToPersonDtoConverter = personToPersonDtoConverter;
        this.personWithTasksDtoConverter = personWithTasksDtoConverter;
    }

    public List<PersonDTO> getPersonDTOs() {
        return personToPersonDtoConverter.convert(personRepository.findAll());
    }

    public List<PersonWithTasksDTO> getPersonWithTasksDTOs() {
        return personWithTasksDtoConverter.convert(personRepository.findAll());
    }

    public PersonDTO getPersonDtoById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personToPersonDtoConverter.convert(personOptional.get());
    }
    public PersonWithTasksDTO getPersonWithTasksDtoById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personWithTasksDtoConverter.convert(personOptional.get());
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
}
