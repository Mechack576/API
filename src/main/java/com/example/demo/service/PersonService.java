package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Method to insert a new person
@Service
public class PersonService {
    private final PersonDao personDao;
    //PersonDao isn't instantiated so it would not run added @repository to FakePersonDateAccess
    @Autowired
    //Injecting into the actual constructor
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }
    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }
    //Get Request
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }


}
