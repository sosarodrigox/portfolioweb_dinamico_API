
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
     //Experiencia: Carga lista de experiencias en el front
    public List<Experiencia> verListaExperiencia();
    
    public void crearExperiencia (Experiencia exp); //Tambien funciona como modificar/update
    
    public void borrarExperiencia(Integer id);
    
    public Experiencia buscarExperiencia(Integer id);
    
    public Experiencia modificarExperiencia(Integer id, Experiencia exp);
}
