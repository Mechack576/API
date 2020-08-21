package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//Interface gives the operations and return type
public interface PersonDao {
    //This methods allows us to insert a person with a given ID
    //The other without an id which is randomly generated.
    int insertPerson(UUID id, Person person);
    //Allows us to generate the UUIDs ourself or
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);

    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
