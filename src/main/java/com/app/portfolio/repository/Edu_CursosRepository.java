
package com.app.portfolio.repository;

import com.app.portfolio.controller.model.Edu_Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Edu_CursosRepository extends JpaRepository<Edu_Cursos,Integer>{
    
}
