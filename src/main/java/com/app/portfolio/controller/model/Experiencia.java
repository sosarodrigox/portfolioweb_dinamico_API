package com.app.portfolio.controller.model;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "experiencia")
@Getter
@Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_exp;

    @Column(name = "organizacion", length = 100, nullable = false)
    private String organizacion;
    @Column(name = "puesto", length = 150, nullable = false)
    private String puesto;
    @Column(name = "fechaDesde", length = 50)
    private String fechaDesde;
    @Column(name = "fechaHasta", length = 50)
    private String fechaHasta;
    @Column(name = "descTareas", length = 1100)
    private String descTareas;
    @Column(name = "imgLogo", length = 255)
    private String imgLogo;

    public Experiencia() {
    }

    public Experiencia(Integer id_exp,
            String organizacion,
            String puesto,
            String fechaDesde,
            String fechaHasta,
            String descTareas,
            String imgLogo) {
        this.id_exp = id_exp;
        this.organizacion = organizacion;
        this.puesto = puesto;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.descTareas = descTareas;
        this.imgLogo = imgLogo;
    }
}

/*
"experiencia": [
		{
			"organizacion": "MIN. DE DESARROLLO SOCIAL E.R.",
			"puesto": "Equipo Técnico LAITEC",
			"fechaDesde": "2014",
			"fechaHasta": "2022",
			"descTareas": "Eq. Técnico Línea de Acción Incorporación de Tecnología. Asistencia y acompañamiento a emprendedores con el objetivo de fortalecer actividades productivas mediante la transferencia de máquinas y herramientas. Tareas de asesoramiento, coordinación, logísticas y administrativas.",
			"imgLogo": "https://i.ibb.co/pfgcMtB/Gob-ER-Logo.jpg"
		},
 */
