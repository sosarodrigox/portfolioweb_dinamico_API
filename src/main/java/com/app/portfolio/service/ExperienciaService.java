
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Experiencia;
import com.app.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired //Sirve para hacer inyección de dependencias.
    public ExperienciaRepository expRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.
    
    //Experiencia: Carga lista de experiencias en el front
    @Override
    public List<Experiencia> verListaExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);//También es Modificar
    }

    @Override
    public void borrarExperiencia(Integer id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Integer id) {
        return expRepo.findById(id).orElse(null); //Si encuentra devuelve una exp, si no devuelve null
    }

    @Override
    public Experiencia modificarExperiencia(Integer id, Experiencia detalleExp) {
        Experiencia exp = expRepo.findById(id).orElse(null);
        
        exp.setOrganizacion(detalleExp.getOrganizacion());
        exp.setPuesto(detalleExp.getPuesto());
        exp.setFechaDesde(detalleExp.getFechaDesde());
        exp.setFechaHasta(detalleExp.getFechaHasta());
        exp.setDescTareas(detalleExp.getDescTareas());
        exp.setImgLogo(detalleExp.getImgLogo());
        
        Experiencia expActualizada = expRepo.save(exp);
        return expActualizada;
    }
}
