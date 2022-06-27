
package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Experiencia;
import com.app.portfolio.service.IExperienciaService;
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
public class ControllerExperiencia {
    
    @Autowired
    private IExperienciaService expServ; //Este servicio contiene los métodos de experiencia.
    
    //Métodos de Experiencia:
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva/experiencia") //Esta anotación permite utilizar el método POST para agregar una nueva exp.
    public void agregarExperiencia(@RequestBody Experiencia exp){//El requestbody sirve para enviar el objeto en formato json.
        expServ.crearExperiencia(exp);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/lista-exp")
    @ResponseBody
    public List<Experiencia> verListaExperiencia(){
        return expServ.verListaExperiencia();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping  ("/borrar-exp/{id}")
    public void borrarExperiencia(@PathVariable Integer id){
        expServ.borrarExperiencia(id);
    }
    
    @GetMapping ("/traer-exp/{id}")
    public Experiencia buscarExperiencia(@PathVariable Integer id){
        return expServ.buscarExperiencia(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("modif-exp/{id}")
    public ResponseEntity<Experiencia> modificarExperiencia(@PathVariable Integer id, @RequestBody Experiencia detalleExp){
       return ResponseEntity.ok(expServ.modificarExperiencia(id, detalleExp));
    }          
}
