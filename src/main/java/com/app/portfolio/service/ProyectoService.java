
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Proyecto;
import com.app.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proyRepo;

    @Override
    public List<Proyecto> verProyectos() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proy) {
        proyRepo.save(proy);
    }

    @Override
    public void borrarProyecto(Integer id) {
        proyRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Integer id) {
        return proyRepo.findById(id).orElse(null);
    }

    @Override
    public Proyecto modificarProyecto(Integer id, Proyecto proy) {
        Proyecto proyecto = proyRepo.findById(id).orElse(null);
        
        proyecto.setTipo(proy.getTipo());
        proyecto.setNombre(proy.getNombre());
        proyecto.setDescripcion(proy.getDescripcion());
        proyecto.setTecnologias(proy.getTecnologias());
        proyecto.setGithub_link(proy.getGithub_link());
        
        Proyecto proyectoActualizado = proyRepo.save(proyecto);
        return proyectoActualizado;
    }
}