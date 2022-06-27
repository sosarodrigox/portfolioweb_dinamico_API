package com.app.portfolio.controller;

import com.app.portfolio.controller.model.Skill_Hard;
import com.app.portfolio.service.ISkill_HardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ControllerSkill_Hard {
    
    @Autowired
    private ISkill_HardService h_SkillService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva/h_skill")
    public void agregarHardSkill(@RequestBody Skill_Hard skill_h){
        h_SkillService.crearSkill_Hard(skill_h);
    }
    
    @GetMapping("/Ver/lista-skill-h")
    @ResponseBody
    public List<Skill_Hard> verListaSkill_Hard(){
        return h_SkillService.verListaSkill_Hard();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar-skill-h/{id}")
    public void borrarSkillHard(@PathVariable Integer  id){
        h_SkillService.borrarSkill_Hard(id);
    }
    
    @GetMapping("/traer-skill-h/{id}")
    public Skill_Hard buscarSkillHard(@PathVariable Integer id){
        return h_SkillService.buscarSkill_Hard(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("modif-hardskill/{id}")
    public ResponseEntity<Skill_Hard> modificarSkillHard(@PathVariable Integer id, @RequestBody Skill_Hard detalleHS){
       return ResponseEntity.ok(h_SkillService.modificarSkill_Hard(id, detalleHS));
    } 
}