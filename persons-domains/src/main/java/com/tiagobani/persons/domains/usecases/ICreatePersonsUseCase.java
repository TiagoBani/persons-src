package com.tiagobani.persons.domains.usecases;

import com.tiagobani.persons.domains.domain.PersonCreateRequest;

public interface ICreatePersonsUseCase {

    void handle(PersonCreateRequest request);
}
