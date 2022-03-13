package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonFindResultDto;
import com.tiagobani.persons.domains.usecases.IFindByIdPersonsUseCase;
import com.tiagobani.persons.ports.IFindByIdPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindByIdPersonAdapter implements IFindByIdPersonsUseCase {

    private final IFindByIdPersonsPort port;

    @Override
    public Optional<PersonFindResultDto> handle(UUID personId) {
        return port.handle(personId).map(person -> new PersonFindResultDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getCreatedAt(),
                person.getUpdatedAt()
        ));
    }
}
