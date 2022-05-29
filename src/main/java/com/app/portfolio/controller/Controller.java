
package com.app.portfolio.controller;
import com.app.portfolio.controller.model.Experiencia;
import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    
    @Autowired
    private IPersonaService persoServ; //Este servicio contiene los métodos de persona (header, aboutMe), experiencia, etc.
    
    //Métodos de Personas:
    @PostMapping("/new/persona") //Esta anotación permite utilizar el método POST para agregar una persona.
    public void agregarPersona(@RequestBody Persona pers){
        //listaPersonas.add(pers);
        persoServ.crearPersona(pers);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        //return listaPersonas;
        return persoServ.verPersonas();
    }
    
    @DeleteMapping  ("/delete/{id}")
    public void borrarPersona(@PathVariable Integer id){
        persoServ.borrarPersona(id);
    }
    
    @GetMapping ("/traer/{id}")
    public Persona buscarPersona(@PathVariable Integer id){
        return persoServ.buscarPersona(id);
    }
    
    //Métodos de Experiencia:
    @PostMapping("/nueva/experiencia") //Esta anotación permite utilizar el método POST para agregar una nueva exp.
    public void agregarExperiencia(@RequestBody Experiencia exp){
        persoServ.crearExperiencia(exp);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/lista-exp")
    @ResponseBody
    public List<Experiencia> verListaExperiencia(){
        //return listaPersonas;
        return persoServ.verListaExperiencia();
    }
    
    @DeleteMapping  ("/borrar-exp/{id}")
    public void borrarExperiencia(@PathVariable Integer id){
        persoServ.borrarExperiencia(id);
    }
    
    @GetMapping ("/traer-exp/{id}")
    public Experiencia buscarExperiencia(@PathVariable Integer id){
        return persoServ.buscarExperiencia(id);
    }
}
