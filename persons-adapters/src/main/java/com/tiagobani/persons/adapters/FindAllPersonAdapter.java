package com.tiagobani.persons.adapters;

import com.tiagobani.persons.domains.domain.PersonFindResultDto;
import com.tiagobani.persons.domains.usecases.IFindAllPersonsUseCase;
import com.tiagobani.persons.ports.IFindAllPersonsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindAllPersonAdapter implements IFindAllPersonsUseCase {

    private final IFindAllPersonsPort port;

    @Override
    public Set<PersonFindResultDto> handle() {
        return port.handle().parallelStream().map(person -> new PersonFindResultDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getCreatedAt(),
                person.getUpdatedAt()
        )).collect(Collectors.toSet());
    }
}
