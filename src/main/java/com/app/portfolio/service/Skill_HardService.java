

package com.app.portfolio.service;

import com.app.portfolio.controller.model.Skill_Hard;
import com.app.portfolio.repository.Skill_HardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Skill_HardService implements ISkill_HardService{
  
    @Autowired //Sirve para hacer inyección de dependencias.
    public Skill_HardRepository skillHard_Repo; //Crea un repositorio el cual nos sirve para no estar creando instancias por cada método.
    
    //Skill_Hard: Carga lista de experiencias en el front
    @Override
    public List<Skill_Hard> verListaSkill_Hard() {
        return skillHard_Repo.findAll();
    }

    @Override
    public void crearSkill_Hard(Skill_Hard s_hard) {
        skillHard_Repo.save(s_hard); //Tambien sirve para update/modificar.
    }

    @Override
    public void borrarSkill_Hard(Integer id) {
        skillHard_Repo.deleteById(id);
    }

    @Override
    public Skill_Hard buscarSkill_Hard(Integer id) {
        return skillHard_Repo.findById(id).orElse(null); //Si encuentra devuelve una skill, si no devuelve null
    }
}
