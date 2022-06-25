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
@Table(name = "edu_cursos")
@Getter
@Setter
public class Edu_Cursos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_curso;

    @Column(name = "institucion", length = 100, nullable = false)
    private String institucion;
    @Column(name = "nom_curso", length = 100, nullable = false)
    private String nom_curso;
    @Column(name = "descripcion", length = 1100)
    private String descripcion;
    @Column(name = "duracion", length = 100, nullable = false)
    private String duracion;
    @Column(name = "fecha_inicio", length = 50, nullable = false)
    private String fecha_inicio;
    @Column(name = "img_logo", length = 1000)
    private String img_logo;

    public Edu_Cursos() {
    }

    public Edu_Cursos(Integer id_curso,
            String institucion,
            String nom_curso,
            String descripcion,
            String duracion,
            String fecha_inicio,
            String img_logo) {
        this.id_curso = id_curso;
        this.institucion = institucion;
        this.nom_curso = nom_curso;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fecha_inicio = fecha_inicio;
        this.img_logo = img_logo;
    }
}