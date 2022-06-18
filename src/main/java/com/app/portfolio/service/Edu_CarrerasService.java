
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Edu_Carreras;
import com.app.portfolio.repository.Edu_CarrerasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Edu_CarrerasService implements IEdu_CarrerasService{
    
    //Edu_Carreras: Carga lista de carreras en el Front
    @Autowired //Sirve para hacer inyección de dependencias.
    public Edu_CarrerasRepository carrerasRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.

    @Override
    public List<Edu_Carreras> verCarreras() {
       return carrerasRepo.findAll();
    }

    @Override
    public void crearCarrera(Edu_Carreras car) {
        carrerasRepo.save(car); //Save es similar al metodo "Create"
    } //Este método también funciona como modificar/update

    @Override
    public void borrarCarrera(Integer id) {
        carrerasRepo.deleteById(id);
    }

    @Override
    public Edu_Carreras buscarCarrera(Integer id) {
        return carrerasRepo.findById(id).orElse(null);
    }

    @Override
    public Edu_Carreras modificarCarrera(Integer id, Edu_Carreras car) {
        Edu_Carreras carrera = carrerasRepo.findById(id).orElse(null);
        
        carrera.setUniversidad(car.getUniversidad());
        carrera.setCarrera(car.getCarrera());
        carrera.setLink_info(car.getLink_info());
        carrera.setFecha_inicio(car.getFecha_inicio());
        carrera.setFecha_fin(car.getFecha_fin());
        carrera.setImg_logo(car.getImg_logo());
        
        Edu_Carreras carreraActualizada = carrerasRepo.save(carrera);
        return carreraActualizada;
    }
}
