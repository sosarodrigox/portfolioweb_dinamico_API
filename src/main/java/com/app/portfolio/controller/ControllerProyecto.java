package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Proyecto;
import com.app.portfolio.service.IProyectoService;
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
@CrossOrigin(origins="*")
public class ControllerProyecto {

    @Autowired
    private IProyectoService proyectoService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/proyecto")
    public void agregarProyecto(@RequestBody Proyecto proy){
        proyectoService.crearProyecto(proy);
    }
    
    @GetMapping("/ver/lista-proyecto")
    @ResponseBody
    public List<Proyecto> verListaProyectos(){
        return proyectoService.verProyectos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar-proyecto/{id}")
    public void borrarProyecto(@PathVariable Integer id){
        proyectoService.borrarProyecto(id);
    }
    
    @GetMapping("/traer-proyecto/{id}")
    public Proyecto buscarProyecto(@PathVariable Integer id){
        return proyectoService.buscarProyecto(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("modificar-proyecto/{id}")
    public ResponseEntity<Proyecto> modificarProyecto(@PathVariable Integer id, @RequestBody Proyecto detalleProyecto){
       return ResponseEntity.ok(proyectoService.modificarProyecto(id, detalleProyecto));
    } 
}