package com.tiagobani.persons.ports.impl;

import com.tiagobani.persons.data.models.Person;
import com.tiagobani.persons.data.repositories.IPersonRepository;
import com.tiagobani.persons.ports.IFindByIdPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindByIdPersonsPort implements IFindByIdPersonsPort {

    private final IPersonRepository repository;

    @Override
    public Optional<Person> handle(UUID personId) {
        return repository.findById(personId);
    }
}
