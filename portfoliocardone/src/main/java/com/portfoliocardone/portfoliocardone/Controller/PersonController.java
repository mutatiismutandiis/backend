package com.portfoliocardone.portfoliocardone.Controller;

import com.portfoliocardone.portfoliocardone.Entity.Person;
import com.portfoliocardone.portfoliocardone.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    
    @Autowired IPersonService ipersonService;
    
    @GetMapping("/person/get")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PostMapping("/person/new")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "The person was created correctly";
    }
    
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "The person was deleted correctly";
    }
    
    //URL:PORT/person/edit/id/name & lastname & img & about me
    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id,
                             @RequestParam("name") String newName,
                             @RequestParam("lastname") String newLastname,
                             @RequestParam("img") String newImg,
                             @RequestParam("aboutme") String newAboutme){
        Person person = ipersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastname(newLastname);
        person.setImg(newImg);
        person.setAboutme(newAboutme);
    
        ipersonService.savePerson(person);
        return person;
    } 
}
