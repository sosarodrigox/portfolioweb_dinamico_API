
package com.app.portfolio.service;

import com.app.portfolio.controller.model.Skill_Hard;
import java.util.List;

public interface ISkill_HardService {
    
    //Skill Hard: Carga lista de habilidades duras/técnicas en el front
    public List<Skill_Hard> verListaSkill_Hard();
    
    public void crearSkill_Hard(Skill_Hard s_hard);
    
    public void borrarSkill_Hard(Integer id);
    
    public Skill_Hard buscarSkill_Hard(Integer id);
    
}
