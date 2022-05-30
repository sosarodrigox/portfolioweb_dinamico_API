
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Edu_Carreras;
import java.util.List;

public interface IEdu_CarrerasService {
    //Edu_Carreras: Carga listado de carreras en el Front
    public List<Edu_Carreras> verCarreras();
    
    public void crearCarrera (Edu_Carreras car); //Tambien funciona como modificar/update
    
    public void borrarCarrera(Integer id);
    
    public Edu_Carreras buscarCarrera(Integer id);  
}
