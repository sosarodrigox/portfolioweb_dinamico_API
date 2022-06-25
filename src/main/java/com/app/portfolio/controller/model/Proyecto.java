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
@Table(name = "proyectos")
@Getter
@Setter
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_proyecto;

    @Column(name = "tipo", length = 100)
    private String tipo;
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    @Column(name = "descripcion", length = 1100)
    private String descripcion;
    @Column(name = "tecnologias", length = 600)
    private String tecnologias;
    @Column(name = "github_link", length = 1000)
    private String github_link;

    public Proyecto() {
    }

    public Proyecto(Integer id_proyecto,
            String tipo,
            String nombre,
            String descripcion,
            String tecnologias,
            String github_link) {
        this.id_proyecto = id_proyecto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tecnologias = tecnologias;
        this.github_link = github_link;
    }
}