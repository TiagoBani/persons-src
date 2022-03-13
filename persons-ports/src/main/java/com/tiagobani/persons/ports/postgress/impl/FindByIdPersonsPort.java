package com.tiagobani.persons.ports.postgress.impl;

import com.tiagobani.persons.data.models.Person;
import com.tiagobani.persons.data.repositories.IPersonRepository;
import com.tiagobani.persons.ports.postgress.IFindByIdPersonsPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByIdPersonsPort implements IFindByIdPersonsPort {

    private final IPersonRepository repository;

    @Override
    public Optional<Person> handle(UUID personId) {
        return repository.findById(personId);
    }
}
