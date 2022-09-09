package com.portfoliocardone.portfoliocardone.Interface;

import com.portfoliocardone.portfoliocardone.Entity.Person;
import java.util.List;

public interface IPersonService {
    //Bring a list of people
    public List<Person> getPerson();

    //Save an objet: person type
    public void savePerson(Person persona);

    //Delete a person
    public void deletePerson(Long id);

    //Look for a person
    public Person findPerson(Long id);    
}
