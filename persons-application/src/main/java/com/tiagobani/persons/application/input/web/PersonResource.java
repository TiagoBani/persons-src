package com.tiagobani.persons.application.input.web;

import com.tiagobani.persons.domains.domain.PersonCreateRequest;
import com.tiagobani.persons.domains.domain.PersonFindResult;
import com.tiagobani.persons.domains.usecases.ICreatePersonsUseCase;
import com.tiagobani.persons.domains.usecases.IFindAllPersonsUseCase;
import com.tiagobani.persons.domains.usecases.IFindByIdPersonsUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonResource {

    private final IFindAllPersonsUseCase findAllPersonsUseCase;
    private final IFindByIdPersonsUseCase findByIdPersonsUseCase;
    private final ICreatePersonsUseCase createPersonsUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<PersonFindResult> getFindAllPersons(){
        return Optional.of(findAllPersonsUseCase.handle())
                .filter(result -> !result.isEmpty())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonFindResult getFindByIdPersons(@PathVariable("id") UUID personId){
        return findByIdPersonsUseCase.handle(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postCreatePersons(@Valid @RequestBody PersonCreateRequest request){
        createPersonsUseCase.handle(request);
    }

}
