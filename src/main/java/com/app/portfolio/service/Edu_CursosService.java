

package com.app.portfolio.service;

import com.app.portfolio.controller.model.Edu_Cursos;
import com.app.portfolio.repository.Edu_CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Edu_CursosService implements IEdu_CursosService{

    //Edu_Cursos: Carga lista de cursos en el Front
    @Autowired //Sirve para hacer inyección de dependencias.
    public Edu_CursosRepository cursosRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.

    
    @Override
    public List<Edu_Cursos> verCursos() {
        return cursosRepo.findAll();
    }

    @Override
    public void crearCurso(Edu_Cursos cur) {
        cursosRepo.save(cur); //Save es similar al metodo "Create"
    } //Este método también funciona como modificar/update

    @Override
    public void borrarCurso(Integer id) {
        cursosRepo.deleteById(id);
    }

    @Override
    public Edu_Cursos buscarCurso(Integer id) {
        return cursosRepo.findById(id).orElse(null);
    }

}
