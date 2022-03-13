package com.tiagobani.persons.ports.postgress.impl;

import com.tiagobani.persons.data.models.Address;
import com.tiagobani.persons.data.models.Person;
import com.tiagobani.persons.data.repositories.IPersonRepository;
import com.tiagobani.persons.domains.domain.PersonAddressRequest;
import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import com.tiagobani.persons.ports.postgress.ICreatePersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePersonsPort implements ICreatePersonsPort {

    private final IPersonRepository personRepository;

    @Override
    public void handle(PersonCreateResponse response, PersonAddressRequest addressRequest) {
        var person = personRepository.saveAndFlush(new Person(
                response.getId(),
                response.getFirstName(),
                response.getLastName(),
                response.getEmail(),
                response.getCreatedAt(),
                null,
                null
        ));

        person.setAddress(new Address(
                addressRequest.getId(),
                addressRequest.getPostalCode(),
                addressRequest.getStreetName(),
                null,
                addressRequest.getComplement(),
                addressRequest.getNeighborhood(),
                addressRequest.getCity(),
                addressRequest.getState(),
                addressRequest.getCreatedAt(),
                null,
                person
        ));
        personRepository.save(person);
    }
}

