package com.portfoliocardone.portfoliocardone.Service;

import com.portfoliocardone.portfoliocardone.Entity.Experience;
import com.portfoliocardone.portfoliocardone.Interface.IExperienceService;
import com.portfoliocardone.portfoliocardone.Repository.IExperienceRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienceService implements IExperienceService{
    
    @Autowired IExperienceRepository iexperienceRepository;
    @Override
    public List<Experience> getExperience() {
       List<Experience> experience = iexperienceRepository.findAll();
       return experience;
    }
    
    @Override
    public void saveExperience(Experience experience) {
        iexperienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        iexperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = iexperienceRepository.findById(id).orElse(null);
        return experience;
    }
    
}
