package com.tiagobani.persons.ports.impl;

import com.tiagobani.persons.data.models.Person;
import com.tiagobani.persons.data.repositories.IPersonRepository;
import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import com.tiagobani.persons.ports.ICreatePersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePersonsPort implements ICreatePersonsPort {

    private final IPersonRepository personRepository;

    @Override
    public void handle(PersonCreateResponse response) {
        personRepository.save(new Person(
            response.getId(),
            response.getFirstName(),
            response.getLastName(),
            response.getEmail(),
            response.getCreatedAt(),
            null
        ));
    }
}
