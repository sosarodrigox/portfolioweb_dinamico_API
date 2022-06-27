
package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Edu_Carreras;
import com.app.portfolio.service.IEdu_CarrerasService;
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
public class ControllerEdu_Carreras {

    @Autowired
    private IEdu_CarrerasService carServ; //Este servicio contiene los métodos de Edu_Carreras.
    
    //Métodos de Edu_Carreras:
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva/carrera") //Esta anotación permite utilizar el método POST para agregar una nueva carrera.
    public void agregarCarrera(@RequestBody Edu_Carreras car){
        carServ.crearCarrera(car);
    } //También funciona como modificar/update
    
    @GetMapping("/ver/lista-carreras")
    @ResponseBody
    public List<Edu_Carreras> verListaCarreras(){
        return carServ.verCarreras();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping  ("/borrar-carrera/{id}")
    public void borrarCarrera(@PathVariable Integer id){
        carServ.borrarCarrera(id);
    }
    
    @GetMapping ("/traer-carrera/{id}")
    public Edu_Carreras buscarCarrera(@PathVariable Integer id){
        return carServ.buscarCarrera(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("modif-carrera/{id}")
    public ResponseEntity<Edu_Carreras> modificarCarrera(@PathVariable Integer id, @RequestBody Edu_Carreras detalleCar){
       return ResponseEntity.ok(carServ.modificarCarrera(id, detalleCar));
    }  
}
