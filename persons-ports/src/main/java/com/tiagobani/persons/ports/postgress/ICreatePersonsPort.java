package com.tiagobani.persons.ports.postgress;

import com.tiagobani.persons.domains.domain.PersonAddressRequest;
import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import org.springframework.stereotype.Component;

@Component
public interface ICreatePersonsPort {

    void handle(PersonCreateResponse personCreate, PersonAddressRequest address);
}
