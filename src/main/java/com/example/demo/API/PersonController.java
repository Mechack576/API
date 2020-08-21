package com.example.demo.API;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//Post, Get, Delete, Put Methods live in here

@RequestMapping("api/v1/person")
@RestController //Means that this is where the methods go
public class PersonController {
    private final PersonService personService;

    @Autowired //Inserts the actual service
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    //Method that adds a person
    @PostMapping // Post request //@Valid @NonNull
    public void insertPerson(@RequestBody Person person){ //RequestBody tells the json payload that we're receiving it from the actual body
        //Turns the Json object into a person
        personService.insertPerson(person);
    }
    @GetMapping //It is a get request
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}") //getting by ID
    public Person getPersonById(@PathVariable("id") UUID id){ //Annotation to get a person by ID
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
                                                        //@Valid @NonNull
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }


}
