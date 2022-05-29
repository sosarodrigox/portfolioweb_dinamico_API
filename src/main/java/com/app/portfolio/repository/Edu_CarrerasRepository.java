package com.app.portfolio.repository;

import com.app.portfolio.controller.model.Edu_Carreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Edu_CarrerasRepository extends JpaRepository<Edu_Carreras,Integer>{
    
}
