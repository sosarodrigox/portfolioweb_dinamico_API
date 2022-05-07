
package com.app.portfolio.controller;
import com.app.portfolio.controller.model.Persona;
import com.app.portfolio.service.IPersonaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    /*List<Persona> listaPersonas = new ArrayList();
    
    @GetMapping ("/hola/{nombre}/{apellido}/{edad}")
    public String decirHola(@PathVariable String nombre,
                            @PathVariable String apellido,
                            @PathVariable int edad){
        return "Hola " + nombre + " Tu apellido es: " + apellido + " y tu Edad: " + edad;
    }
    
    @GetMapping("/chau")
    public String decirChau(@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam int edad){
        return "Chau mundo " + nombre + " Tu apellido es: " + apellido + " y tu Edad: " + edad;
    }
    */
    
    @Autowired
    private IPersonaService persoServ;
    
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
}
