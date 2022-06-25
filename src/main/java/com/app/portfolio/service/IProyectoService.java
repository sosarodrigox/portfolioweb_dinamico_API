
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    //ProyectosService: Carga lista de proyectos realizados en el front
    public List<Proyecto> verProyectos();
    
    public void crearProyecto(Proyecto proy);
    
    public void borrarProyecto(Integer id);
    
    public Proyecto buscarProyecto(Integer id);
    
    public Proyecto modificarProyecto(Integer id, Proyecto proy);
}
