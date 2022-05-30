
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Edu_Cursos;
import java.util.List;

public interface IEdu_CursosService {
    //Edu_Carreras: Carga listado de cursos en el Front
    public List<Edu_Cursos> verCursos();
    
    public void crearCurso (Edu_Cursos cur); //Tambien funciona como modificar/update
    
    public void borrarCurso(Integer id);
    
    public Edu_Cursos buscarCurso(Integer id);  
    
}
