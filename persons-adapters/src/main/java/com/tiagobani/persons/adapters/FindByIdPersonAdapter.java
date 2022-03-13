package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonAddressResponse;
import com.tiagobani.persons.domains.domain.PersonFindResult;
import com.tiagobani.persons.domains.usecases.IFindByIdPersonsUseCase;
import com.tiagobani.persons.ports.postgress.IFindByIdPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindByIdPersonAdapter implements IFindByIdPersonsUseCase {

    private final IFindByIdPersonsPort port;

    @Override
    public Optional<PersonFindResult> handle(UUID personId) {
        return port.handle(personId).map(person -> new PersonFindResult(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getCreatedAt(),
                person.getUpdatedAt(),
                Optional.ofNullable(person.getAddress())
                    .map(address -> new PersonAddressResponse(
                            address.getId(),
                            address.getPostalCode(),
                            address.getStreetName(),
                            address.getComplement(),
                            address.getNeighborhood(),
                            address.getCity(),
                            address.getState(),
                            address.getStreetNumber(),
                            address.getCreatedAt(),
                            address.getUpdatedAt()
                    )).orElse(null)
        ));
    }
}
