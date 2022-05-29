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
@Table(name = "edu_carreras")
@Getter
@Setter
public class Edu_Carreras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_carrera;

    @Column(name = "universidad", length = 100, nullable = false)
    private String universidad;
    @Column(name = "carrera", length = 250, nullable = false)
    private String carrera;
    @Column(name = "link_info", length = 1000)
    private String link_info;
    @Column(name = "fecha_inicio", length = 50, nullable = false)
    private String fecha_inicio;
    @Column(name = "fecha_fin", length = 50, nullable = false)
    private String fecha_fin;
    @Column(name = "img_logo", length = 1000)
    private String img_logo;

    public Edu_Carreras() {
    }

    public Edu_Carreras(Integer id_carrera,
            String universidad,
            String carrera,
            String link_info,
            String fecha_inicio,
            String fecha_fin,
            String img_logo) {
        this.id_carrera = id_carrera;
        this.universidad = universidad;
        this.carrera = carrera;
        this.link_info = link_info;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.img_logo = img_logo;
    }
}

/*
{
	"universidad": "INSTITUTO SUPERIOR POLITÉCNICO DE CORDOBA",
	"carrera": "Tecnicatura Superior en Ciencia de Datos e Inteligencia Artificial",
	"linkMasInfo": "https://ispc.prod.tucampus.org/tecnicatura-datos/",
	"fechaInicio": "2022",
	"fechaFin": "En curso",
	"imgLogo": "https://i.ibb.co/GdPLF03/ISPC-logo.png"
}
*/
