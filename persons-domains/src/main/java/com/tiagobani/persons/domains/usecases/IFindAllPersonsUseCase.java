package com.tiagobani.persons.domains.usecases;

import com.tiagobani.persons.domains.domain.PersonFindResult;

import java.util.Set;

public interface IFindAllPersonsUseCase {

    Set<PersonFindResult> handle();
}
