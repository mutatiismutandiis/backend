package com.portfoliocardone.portfoliocardone.Interface;

import com.portfoliocardone.portfoliocardone.Entity.Experience;
import java.util.List;

public interface IExperienceService {
    //Bring an experience
    public List<Experience> getExperience();

    //Save an objet: experience type
    public void saveExperience(Experience experience);

    //Delete an experience
    public void deleteExperience(Long id);

    //Look for an experience
    public Experience findExperience(Long id);
}
