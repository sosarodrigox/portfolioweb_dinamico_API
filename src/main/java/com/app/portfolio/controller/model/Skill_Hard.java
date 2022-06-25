package com.app.portfolio.controller.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill_hard")
@Getter
@Setter
public class Skill_Hard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_hardskill;

    @Column(name = "skill", length = 100, nullable = false)
    private String skill;
    @Column(name = "descripcion", length = 1100)
    private String descripcion;
    @Column(name = "porcentaje", nullable = false)
    private Integer porcentaje;

    public Skill_Hard() {
    }

    public Skill_Hard(Integer id_hardskill,
            String skill,
            String descripcion,
            Integer porcentaje) {
        this.id_hardskill = id_hardskill;
        this.skill = skill;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }
}