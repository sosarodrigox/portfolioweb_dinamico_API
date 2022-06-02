
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
}
