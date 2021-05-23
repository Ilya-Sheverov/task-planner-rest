package com.github.sheverov.ilya.taskplannerrest.database;

import com.github.sheverov.ilya.taskplannerrest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
