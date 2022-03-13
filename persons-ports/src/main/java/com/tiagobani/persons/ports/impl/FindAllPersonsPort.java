package com.tiagobani.persons.ports.impl;

import com.tiagobani.persons.data.models.Person;
import com.tiagobani.persons.data.repositories.IPersonRepository;
import com.tiagobani.persons.ports.IFindAllPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllPersonsPort implements IFindAllPersonsPort {

    private final IPersonRepository repository;

    @Override
    public List<Person> handle() {
        return repository.findAll();
    }
}
