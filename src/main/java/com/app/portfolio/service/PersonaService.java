
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Experiencia;
import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.repository.ExperienciaRepository;
import com.app.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    //Persona: Carga header y aboutMe en el Front
    @Autowired //Sirve para hacer inyección de dependencias.
    public PersonaRepository persoRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.
    @Autowired //Sirve para hacer inyección de dependencias.
    public ExperienciaRepository expRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.
    
    @Override
    public List<Persona> verPersonas() {
       return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per); //Save es similar al metodo "Create"
    } //Este método también funciona como modificar/update

    @Override
    public void borrarPersona(Integer id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Integer id) {
        return persoRepo.findById(id).orElse(null);
    }
    
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
        return expRepo.findById(id).orElse(null);
    }
}
