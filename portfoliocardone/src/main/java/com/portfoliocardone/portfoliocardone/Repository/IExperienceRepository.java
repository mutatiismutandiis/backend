package com.portfoliocardone.portfoliocardone.Repository;

import com.portfoliocardone.portfoliocardone.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience,Long>{
    
}
