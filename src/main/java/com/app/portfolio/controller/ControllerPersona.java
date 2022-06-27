package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerPersona {
    
    @Autowired
    private IPersonaService persoServ; //Este servicio contiene los métodos de persona (header, aboutMe), experiencia, etc.
    
    //Métodos de Personas:
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/persona") //Esta anotación permite utilizar el método POST para agregar una persona.
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping  ("/delete/{id}")
    public void borrarPersona(@PathVariable Integer id){
        persoServ.borrarPersona(id);
    }
    
     @GetMapping ("/traer-persona/{id}")
    public Persona buscarPersona(@PathVariable Integer id){
        return persoServ.buscarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("modif-persona/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Integer id, @RequestBody Persona detallePersona){
       return ResponseEntity.ok(persoServ.modificarPersona(id, detallePersona));
    }          
}
