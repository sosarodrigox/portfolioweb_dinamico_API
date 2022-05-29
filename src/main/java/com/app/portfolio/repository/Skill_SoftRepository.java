
package com.app.portfolio.repository;

import com.app.portfolio.controller.model.Skill_Soft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Skill_SoftRepository extends JpaRepository<Skill_Soft,Integer>{
    
}
