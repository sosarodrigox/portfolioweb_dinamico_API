
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Persona;
import java.util.List;

public interface IPersonaService {
    //Persona: Carga header y aboutMe en el Front
    public List<Persona> verPersonas();
    
    public void crearPersona (Persona per); //Tambien funciona como modificar/update
    
    public void borrarPersona(Integer id);
    
    public Persona buscarPersona(Integer id);
    
    public Persona modificarPersona(Integer id, Persona per);
}
