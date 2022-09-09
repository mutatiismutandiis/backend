package com.portfoliocardone.portfoliocardone.Service;

import com.portfoliocardone.portfoliocardone.Entity.Person;
import com.portfoliocardone.portfoliocardone.Interface.IPersonService;
import com.portfoliocardone.portfoliocardone.Repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService {
    
    @Autowired IPersonRepository ipersonRepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person =ipersonRepository.findAll();
        return person;
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
       Person person = ipersonRepository.findById(id).orElse(null);
       return person;
    }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }
}
