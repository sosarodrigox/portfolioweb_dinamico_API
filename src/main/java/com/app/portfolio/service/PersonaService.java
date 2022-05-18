
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired //Sirve para hacer inyección de dependencias.
    public PersonaRepository persoRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.
    
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

}
