package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonAddressRequest;
import com.tiagobani.persons.domains.domain.PersonCreateRequest;
import com.tiagobani.persons.domains.domain.PersonCreateResponse;
import com.tiagobani.persons.domains.usecases.ICreatePersonsUseCase;
import com.tiagobani.persons.ports.postgress.ICreatePersonsPort;
import com.tiagobani.persons.ports.viacep.IFindAddressViaCep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePersonAdapter implements ICreatePersonsUseCase {

    private final ICreatePersonsPort createPersonsPort;
    private final IFindAddressViaCep findAddressPort;

    @Override
    public void handle(PersonCreateRequest request) {
        var address = findAddressPort.handle(request.getPostalCode());
        createPersonsPort.handle(
                new PersonCreateResponse(request.getFirstName(), request.getLastName(), request.getEmail()),
                new PersonAddressRequest(address.getPostalCode(), address.getStreetName(), address.getComplement(),
                        address.getNeighborhood(), address.getCity(), address.getState())
        );
    }
}
