package com.portfoliocardone.portfoliocardone.Repository;

import com.portfoliocardone.portfoliocardone.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education,Long> {
    
}
