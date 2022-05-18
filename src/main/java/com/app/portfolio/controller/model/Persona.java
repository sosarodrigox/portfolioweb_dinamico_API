package com.app.portfolio.controller.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombre;
    private String apellido;
    private String posicion;
    private String ubicacion;
    private String nom_usuario;
    private String img_usuario;
    private String img_perfil;
    private String email;
    private String link_cv;
    private String link_github;
    private String link_linkedin;
    private String titulo_slide1;
    private String desc_slide1;
    private String titulo_slide2;
    private String desc_slide2;
    private String titulo_slide3;
    private String desc_slide3;
    private String acerca_de_mi;
    private String me_interesa;
    private String hobbies;

    public Persona(){
    }
    
     public Persona(Integer id, 
                    String nombre,
                    String apellido,
                    String posicion,
                    String ubicacion,
                    String nom_usuario,
                    String img_usuario,
                    String img_perfil,
                    String email,
                    String link_cv,
                    String link_github,
                    String link_linkedin,
                    String titulo_slide1,
                    String desc_slide1,
                    String titulo_slide2,
                    String desc_slide2,
                    String titulo_slide3,
                    String desc_slide3,
                    String acerca_de_mi,
                    String me_interesa,
                    String hobbies            
             ){
         this.id = id;
         this.nombre = nombre;
         this.apellido = apellido;
         this.posicion = posicion;
         this.ubicacion = ubicacion;
         this.nom_usuario = nom_usuario;
         this.img_usuario = img_usuario;
         this.img_perfil = img_perfil;
         this.email = email;
         this.link_cv = link_cv;
         this.link_github = link_github;
         this.link_linkedin = link_linkedin;
         this.titulo_slide1 = titulo_slide1;
         this.desc_slide1 = desc_slide1;
         this.titulo_slide2 = titulo_slide2;
         this.desc_slide2 = desc_slide2;
         this.titulo_slide3 = titulo_slide3;
         this.desc_slide3 = desc_slide3;
         this.acerca_de_mi = acerca_de_mi;
         this.me_interesa = me_interesa;
         this.hobbies = hobbies;
    } 
}
