package com.tiagobani.persons.data.repositories;

import com.tiagobani.persons.data.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPersonRepository extends JpaRepository<Person, UUID> {

}
