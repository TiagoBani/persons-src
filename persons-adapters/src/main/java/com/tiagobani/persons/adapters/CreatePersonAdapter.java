package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonCreateRequest;
import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import com.tiagobani.persons.domains.usecases.ICreatePersonsUseCase;
import com.tiagobani.persons.ports.ICreatePersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@RequiredArgsConstructor
public class CreatePersonAdapter implements ICreatePersonsUseCase {

    private final ICreatePersonsPort port;

    @Override
    public void handle(@Valid PersonCreateRequest request) {
        port.handle(new PersonCreateResponse(request.getFirstName(), request.getLastName(), request.getEmail()));
    }
}
