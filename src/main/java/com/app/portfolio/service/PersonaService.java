
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    //Persona: Carga header y aboutMe en el Front
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

    @Override
    public Persona modificarPersona(Integer id, Persona detallePer) {
       Persona per = persoRepo.findById(id).orElse(null);
       
       per.setNombre(detallePer.getNombre());
       per.setApellido(detallePer.getApellido());
       per.setPosicion(detallePer.getPosicion());
       per.setUbicacion(detallePer.getUbicacion());
       per.setNom_usuario(detallePer.getNom_usuario());
       per.setImg_usuario(detallePer.getImg_usuario());
       per.setImg_perfil(detallePer.getImg_perfil());
       per.setEmail(detallePer.getEmail());
       per.setLink_cv(detallePer.getLink_cv());
       per.setLink_github(detallePer.getLink_github());
       per.setLink_linkedin(detallePer.getLink_linkedin());
       per.setTitulo_slide1(detallePer.getTitulo_slide1());
       per.setDesc_slide1(detallePer.getDesc_slide1());
       per.setTitulo_slide2(detallePer.getTitulo_slide2());
       per.setDesc_slide2(detallePer.getDesc_slide2());
       per.setTitulo_slide3(detallePer.getTitulo_slide3());
       per.setDesc_slide3(detallePer.getDesc_slide3());
       per.setAcerca_de_mi(detallePer.getAcerca_de_mi());
       per.setMe_interesa(detallePer.getMe_interesa());
       per.setHobbies(detallePer.getHobbies());
       
       Persona perActualizada = persoRepo.save(per);
       return perActualizada;
    }
}
