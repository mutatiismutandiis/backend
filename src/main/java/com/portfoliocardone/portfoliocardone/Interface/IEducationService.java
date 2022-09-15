package com.portfoliocardone.portfoliocardone.Interface;

import com.portfoliocardone.portfoliocardone.Entity.Education;
import java.util.List;

public interface IEducationService {
    //Bring an education
    public List<Education> getEducation();

    //Save an objet: ducation type
    public void saveEducation(Education education);

    //Delete an education
    public void deleteEducation(Long id);

    //Look for an education
    public Education findEducation(Long id);
}
