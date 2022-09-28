package com.portfoliocardone.portfoliocardone.Controller;

import com.portfoliocardone.portfoliocardone.Entity.Education;
import com.portfoliocardone.portfoliocardone.Interface.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliocardone.web.app")
public class EducationController {
    
    @Autowired IEducationService ieducationService;
    
    @GetMapping("/education/get")
    public List<Education> getEducation(){
        return ieducationService.getEducation();
    }
    
    @PostMapping("/education/new")
    public String createEducation(@RequestBody Education education){
        ieducationService.saveEducation(education);
        return "The education was created correctly";
    }
    
    @DeleteMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable Long id){
        ieducationService.deleteEducation(id);
        return "The education was deleted correctly";
    }
    
    //URL:PORT/education/edit/id/title & time & location & description
    @PutMapping("/education/edit/{id}")
    public Education editEducation(@PathVariable Long id,
                             @RequestParam("title") String newTitle,
                             @RequestParam("time") String newTime,
                             @RequestParam("location") String newLocation,
                             @RequestParam("description") String newDescription){
        Education education = ieducationService.findEducation(id);
        
        education.setTitle(newTitle);
        education.setTime(newTime);
        education.setLocation(newLocation);
        education.setDescription(newDescription);
    
        ieducationService.saveEducation(education);
        return education;
    }

    @GetMapping("/education/find/profile/{id}")
    public Education findEducation(@PathVariable("id") Long id){
        return ieducationService.findEducation((long)1);
    }
}
