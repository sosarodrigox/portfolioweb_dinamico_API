

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

    @Override
    public Edu_Cursos modificarCurso(Integer id, Edu_Cursos cur) {
        Edu_Cursos curso = cursosRepo.findById(id).orElse(null);
        
        curso.setInstitucion(cur.getInstitucion());
        curso.setNom_curso(cur.getNom_curso());
        curso.setDescripcion(cur.getDescripcion());
        curso.setDuracion(cur.getDuracion());
        curso.setFecha_inicio(cur.getFecha_inicio());
        curso.setImg_logo(cur.getImg_logo());
        
        Edu_Cursos cursoActualizado = cursosRepo.save(curso);
        return cursoActualizado;
    }

}
