
package com.app.portfolio.repository;

import com.app.portfolio.controller.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer>{
    
}
