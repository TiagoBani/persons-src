package com.tiagobani.persons.ports.postgress;

import com.tiagobani.persons.data.models.Person;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface IFindByIdPersonsPort {

    Optional<Person> handle(UUID personId);
}
