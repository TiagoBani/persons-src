package com.tiagobani.persons.ports;

import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import org.springframework.stereotype.Component;

@Component
public interface ICreatePersonsPort {

    void handle(PersonCreateResponse personCreateResponse);
}
