
package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Edu_Cursos;
import com.app.portfolio.service.IEdu_CursosService;
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
public class ControllerEdu_Cursos {
    
    @Autowired
    private IEdu_CursosService curServ; //Este servicio contiene los métodos de Edu_Cursos.
    
    //Métodos de Edu_Cursos:
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo/curso") //Esta anotación permite utilizar el método POST para agregar un nuevo curso.
    public void agregarCurso(@RequestBody Edu_Cursos cur){
        curServ.crearCurso(cur);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/lista-cursos")
    @ResponseBody
    public List<Edu_Cursos> verListaCursos(){
        return curServ.verCursos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping  ("/borrar-curso/{id}")
    public void borrarCurso(@PathVariable Integer id){
        curServ.borrarCurso(id);
    }
    
    @GetMapping ("/traer-curso/{id}")
    public Edu_Cursos buscarCurso(@PathVariable Integer id){
        return curServ.buscarCurso(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("modif-curso/{id}")
    public ResponseEntity<Edu_Cursos> modificarCurso(@PathVariable Integer id, @RequestBody Edu_Cursos detalleCur){
       return ResponseEntity.ok(curServ.modificarCurso(id, detalleCur));
    }  
}