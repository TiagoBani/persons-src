package com.tiagobani.persons.domains.usecases;

import com.tiagobani.persons.domains.domain.PersonFindResult;

import java.util.Optional;
import java.util.UUID;

public interface IFindByIdPersonsUseCase {

    Optional<PersonFindResult> handle(UUID personId);
}
