package com.tiagobani.persons.domains.usecases;

import com.tiagobani.persons.domains.domain.PersonFindResultDto;

import java.util.Set;

public interface IFindAllPersonsUseCase {

    Set<PersonFindResultDto> handle();
}
