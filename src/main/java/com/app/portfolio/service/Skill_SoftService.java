

package com.app.portfolio.service;

import com.app.portfolio.controller.model.Skill_Soft;
import com.app.portfolio.repository.Skill_SoftRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Skill_SoftService implements ISkill_SoftService{
    
    @Autowired //Sirve para hacer inyección de dependencias.
    public Skill_SoftRepository skillSoftRepo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.

    @Override
    public List<Skill_Soft> verListaSkill_Soft() {
        return skillSoftRepo.findAll();
    }

    @Override
    public void crearSkill_Soft(Skill_Soft s_soft) {
        skillSoftRepo.save(s_soft); //También sirve para modificar/Update
    }

    @Override
    public void borrarSkill_Soft(Integer id) {
        skillSoftRepo.deleteById(id);
    }

    @Override
    public Skill_Soft buscarSkill_Soft(Integer id) {
        return skillSoftRepo.findById(id).orElse(null); //Si encuentra devuelve una skill, si no devuelve null
    }

}
