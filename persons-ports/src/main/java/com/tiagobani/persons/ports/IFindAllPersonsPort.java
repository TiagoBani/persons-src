package com.tiagobani.persons.ports;

import com.tiagobani.persons.data.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFindAllPersonsPort {

    List<Person> handle();
}
