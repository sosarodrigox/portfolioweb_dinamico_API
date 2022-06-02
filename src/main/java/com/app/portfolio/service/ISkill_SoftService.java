
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Skill_Soft;
import java.util.List;

public interface ISkill_SoftService {
    
    //Skill Soft: Carga lista de habilidades blandas en el front
    public List<Skill_Soft> verListaSkill_Soft();
    
    public void crearSkill_Soft(Skill_Soft s_soft); //Tambien funciona como modificar/update
    
    public void borrarSkill_Soft(Integer id);
    
    public Skill_Soft buscarSkill_Soft(Integer id);
    
}
