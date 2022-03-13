package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonAddressResponse;
import com.tiagobani.persons.domains.domain.PersonFindResult;
import com.tiagobani.persons.domains.usecases.IFindAllPersonsUseCase;
import com.tiagobani.persons.ports.postgress.IFindAllPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindAllPersonAdapter implements IFindAllPersonsUseCase {

    private final IFindAllPersonsPort port;

    @Override
    public Set<PersonFindResult> handle() {
        return port.handle().parallelStream()
            .map(person -> new PersonFindResult(
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
        )).collect(Collectors.toSet());
    }
}
