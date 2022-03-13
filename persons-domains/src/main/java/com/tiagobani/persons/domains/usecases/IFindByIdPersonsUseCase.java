package com.tiagobani.persons.domains.usecases;

import com.tiagobani.persons.domains.domain.PersonFindResultDto;

import java.util.Optional;
import java.util.UUID;

public interface IFindByIdPersonsUseCase {

    Optional<PersonFindResultDto> handle(UUID personId);
}
