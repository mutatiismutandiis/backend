package com.portfoliocardone.portfoliocardone.Service;

import com.portfoliocardone.portfoliocardone.Entity.Education;
import com.portfoliocardone.portfoliocardone.Interface.IEducationService;
import com.portfoliocardone.portfoliocardone.Repository.IEducationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducationService implements IEducationService{

    @Autowired IEducationRepository ieducationRepository;
    
    @Override
    public List<Education> getEducation() {
        List<Education> education = ieducationRepository.findAll();
        return education;
    }

    @Override
    public void saveEducation(Education education) {
        ieducationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        ieducationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = ieducationRepository.findById(id).orElse(null);
        return education;
    }
    
}
