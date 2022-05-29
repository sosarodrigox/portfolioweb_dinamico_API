
package com.app.portfolio.repository;

import com.app.portfolio.controller.model.Skill_Hard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Skill_HardRepository extends JpaRepository<Skill_Hard,Integer>{
    
}
