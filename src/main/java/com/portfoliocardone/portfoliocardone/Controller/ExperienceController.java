package com.portfoliocardone.portfoliocardone.Controller;

import com.portfoliocardone.portfoliocardone.Entity.Experience;
import com.portfoliocardone.portfoliocardone.Interface.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliocardone.web.app")
public class ExperienceController {
    
    @Autowired IExperienceService iexperienceService;
    
    @GetMapping("/experience/get")
    public List<Experience> getExperience(){
        return iexperienceService.getExperience();
    }
    
    @PostMapping("/experience/new")
    public String createExperience(@RequestBody Experience experience){
        iexperienceService.saveExperience(experience);
        return "The experience was created correctly";
    }
    
    @DeleteMapping("/experience/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        iexperienceService.deleteExperience(id);
        return "The experience was deleted correctly";
    }
    
    //URL:PORT/experience/edit/id/title & time & location & description
    @PutMapping("/experience/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
                             @RequestParam("title") String newTitle,
                             @RequestParam("time") String newTime,
                             @RequestParam("location") String newLocation,
                             @RequestParam("description") String newDescription){
        Experience experience = iexperienceService.findExperience(id);
        
        experience.setTitle(newTitle);
        experience.setTime(newTime);
        experience.setLocation(newLocation);
        experience.setDescription(newDescription);
    
        iexperienceService.saveExperience(experience);
        return experience;
    }
        
    @GetMapping("/experience/find/profile/{id}")
    public Experience findExperience(@PathVariable("id") Long id){
        return iexperienceService.findExperience((long)id);
    }
}
