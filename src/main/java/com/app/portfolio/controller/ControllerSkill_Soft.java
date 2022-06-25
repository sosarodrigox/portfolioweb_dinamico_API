package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Skill_Soft;
import com.app.portfolio.service.ISkill_SoftService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins="http://localhost:4200/")
public class ControllerSkill_Soft {
    
    @Autowired
    private ISkill_SoftService s_SkillService;
    
    @PostMapping("/nueva/s_skill")
    public void agregarSoftSkill(@RequestBody Skill_Soft skill_s){
        s_SkillService.crearSkill_Soft(skill_s);
    }
    
    @GetMapping("/Ver/lista-skill-s")
    @ResponseBody
    public List<Skill_Soft> verListaSkill_Soft(){
        return s_SkillService.verListaSkill_Soft();
    }

    @DeleteMapping("/borrar-skill-s/{id}")
    public void borrarSkillSoft(@PathVariable Integer  id){
        s_SkillService.borrarSkill_Soft(id);
    }
    
    @GetMapping("/traer-skill-s/{id}")
    public Skill_Soft buscarSkillSoft(@PathVariable Integer id){
        return s_SkillService.buscarSkill_Soft(id);
    }
    
    @PutMapping("modif-softskill/{id}")
    public ResponseEntity<Skill_Soft> modificarSkillSoft(@PathVariable Integer id, @RequestBody Skill_Soft detalleSS){
       return ResponseEntity.ok(s_SkillService.modificarSkill_Soft(id, detalleSS));
    } 
}