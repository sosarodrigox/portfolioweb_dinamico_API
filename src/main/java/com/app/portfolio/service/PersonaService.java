
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
       return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
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
